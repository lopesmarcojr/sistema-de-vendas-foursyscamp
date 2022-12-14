package communication;

import data.StockData;
import entities.Costumer;
import entities.Product;
import services.SaleService;
import services.StockService;

import java.time.LocalDateTime;
import java.util.*;

public class Main {
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        StockService stockService = new StockService();
        StockData stockData = new StockData();
        SaleService saleService = new SaleService();
        List<String> stock = Collections.singletonList(stockService.getStock());

        System.out.print("1 - Registrar novo produto\n2 - Listar produtos\n");
        System.out.print("Digite a opção: ");
        int resposta = sc.nextInt();

        while(resposta == 1){
            System.out.print("Digite o sku do produto: ");
            String sku = sc.next();
            sc.nextLine();
            System.out.print("Digite a quantidade do produto: ");
            int quantity = sc.nextInt();
            sc.nextLine();
            System.out.print("Digite o valor do produto: ");
            double price = sc.nextDouble();
            sc.nextLine();
            System.out.print("Digite a descrição do produto: ");
            String description = sc.nextLine();
            stockService.registerNewProduct(sku,quantity,description,price);
            System.out.println("Produto cadastrado com sucesso");
            System.out.println();
            System.out.println("1 - Cadastrar outro produto\n2 - Listar produtos");
            System.out.print("Resposta: ");
            resposta = sc.nextInt();
            if(resposta == 2){
                System.out.print(stockService.getStock());
            }
        }

        System.out.println("1 - Realizar uma venda\n2 - Listar produtos\n");
        System.out.print("Digite a opção: ");
        resposta = sc.nextInt();
        System.out.print("Digite o nome do cliente: ");
        String name = sc.next();
        sc.nextLine();
        System.out.print("Digite o CPF do cliente: ");
        int cpf = sc.nextInt();
        sc.nextLine();
        Costumer costumer = new Costumer(name,cpf);
        List<Product> productCart = new ArrayList<>();
        Map<Integer, List> costumerSale = new HashMap<>();

        Product productFound = null;
        int quantity = 0;

        while(resposta == 1){
            System.out.print("Insira o sku do produto a ser vendido: ");
            String sku = sc.next();
            boolean encontrado = false;
            for(int i = 0; i < stock.size(); i++){
                if(stockService.getItem(sku) != null){
                    productFound = (Product) stockService.getItem(sku);
                    System.out.print("Insira a quantidade do produto: ");
                    quantity = sc.nextInt();
                    productFound.setQuantity(quantity);
                    for(i = 0; i < quantity; i++) {
                        productCart.add(productFound);
                        encontrado = true;
                    }
                }
            }
            if(!encontrado){
                System.out.println("Produto não encontrado");
            }
            System.out.print("1 - Inserir outro produto na venda\n2 - Listar produtos\n3 - Finalizar venda\n" +
                    "Digite a opção: ");
            resposta = sc.nextInt();
            if(resposta == 2){
                stockService.getStock();
            }
            if(resposta == 3){
                System.out.print("Insira o método de pagamento: ");
                String pagamento = sc.next();
                LocalDateTime saleDate = LocalDateTime.now();
                saleService.registerNewSale(saleDate, productCart, costumer.getCpf(), pagamento);
                costumer.addListProductsBought(productCart);
                encontrado = true;
                System.out.println("Venda finalizada com sucesso\n");
            }

        }
        System.out.print("1 - Listar vendas\n2 - Realizar outra venda\n3 - Listar vendas por CPF\n4- Sair\nDigite a opção: ");
        resposta = sc.nextInt();
        if(resposta == 1){
            System.out.println(saleService.listSales());
        }
        if(resposta == 3){
            System.out.print("Digite o cpf do cliente: ");
            cpf = sc.nextInt();
            System.out.println(costumer.costumerProducts(cpf));
        }
        if(resposta == 4){
            System.out.println("Vendas encerradas");
        }

    }
}
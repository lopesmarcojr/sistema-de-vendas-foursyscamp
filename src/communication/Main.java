package communication;

import data.StockData;
import entities.Costumer;
import services.SaleService;
import services.StockService;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

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
                System.out.println(stockService.getStock());
            }
        }

        System.out.println("1 - Realizar uma venda\n2 - Listar produtos\n");
        System.out.print("Digite a opção: ");
        resposta = sc.nextInt();
        while(resposta == 1){
            System.out.print("Digite o nome do cliente: ");
            String name = sc.next();
            sc.nextLine();
            System.out.print("Digite o CPF do cliente: ");
            int cpf = sc.nextInt();
            sc.nextLine();
            Costumer costumer = new Costumer(name,cpf);
            System.out.println("Insira o sku do produto a ser vendido: ");
            String sku = sc.next();
            for(int i = 0; i < stock.size(); i++){
                if(stockService.getItem(sku)){
                    System.out.print("Insira a quantidade do produto: ");
                    int quantity = sc.nextInt();
                }
                else{
                    System.out.println("Produto não encontrado");
                }
            }
            System.out.println("1 - Inserir outro produto\n2 - Listar produtos\n3- Finalizar venda\n" +
                    "Digite a opção: ");
            if(resposta == 2){
                stockService.getStock();
            }
            if(resposta == 3){
                stockService
            }

        }

    }
}
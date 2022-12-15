package services;

import data.SaleData;
import entities.Costumer;
import entities.Product;
import entities.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.*;

public class SaleService {

    SaleData saleData = new SaleData();
    List<Object> sales = saleData.listItems();
    List<Product> productList = new ArrayList<>();

    public String registerNewSale(LocalDateTime saleDate, List<Product> products, int cpf, String pagamento){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String saleDateString = saleDate.format(formatter);
        double totalValue = 0.0;
        for(Product p : products){
            totalValue += p.getPrice();
        }
        Sale sale = new Sale(saleDateString, products, pagamento, cpf);
        sale.setTotalValue(totalValue);
        sale.setSaleDate(saleDateString);
        saleData.save(sale);

        return "Nova compra realizada com sucesso!";
    }

    public List<Product> returnProductList(List<Product> products, int quantity){
        for(Product p : products){
            Product product = new Product();
            product.setDescription(p.getDescription());
            product.setQuantity(quantity);
            product.setPrice(p.getPrice());
            product.setSku(p.getSku());
            product.setType(p.getType());
            product.setSize(p.getSize());
            product.setCategory(p.getCategory());
            product.setColor(p.getColor());
            product.setDepartment(p.getDepartment());
            productList.add(product);
        }
        return productList;
    }
    public String listSales(){
        List<Object> sales = saleData.listItems();
        String returnSales = "--------Vendas--------" + '\n';
        for(int i = 0; i < sales.size(); i++){
            returnSales += sales.get(i);
        }
        return returnSales;
    }

    public String toStringProducts(){
        Set<Product> setProducts = new LinkedHashSet<>();
        for(Product p : productList){
            setProducts.add(p);
        }
        String productsList = "";
        System.out.print("--------Produtos comprados--------" + '\n');
        for(Product p : setProducts){
            productsList += "Produto : " + p.getDescription() + '\n' +
                    "Preço : " + p.getPrice() + '\n' +
                    "Quantidade : " + p.getQuantity() + '\n';
        }
        return productsList;
    }

}

package services;

import data.SaleData;
import entities.Product;
import entities.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.List;
import java.util.Map;

public class SaleService {

    SaleData saleData = new SaleData();
    List<Object> sales = saleData.listItems();
    public String registerNewSale(Map<Integer, Map> map, LocalDateTime saleDate, int quantity, Product product){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String saleDateString = saleDate.format(formatter);
        Sale sale = new Sale(saleDateString, map, quantity, product);

        double totalValue = quantity * product.getPrice();
        int newStockQuantity = product.getQuantity() - quantity;
        product.setQuantity(newStockQuantity);
        sale.setTotalValue(totalValue);
        sale.setSaleDate(saleDateString);
        saleData.save(sale);

        return "Nova compra realizada com sucesso!";
    }

    public String listSales(){
        List<Object> sales = saleData.listItems();
        String returnSales = "Vendas: ";
        for(int i = 0; i < sales.size(); i++){
            returnSales += sales.get(i);
        }
        return returnSales;
    }

    public String listSalesByCpf(int cpf){
        Object sale = null;
        for(int i = 0; i < sales.size(); i++){
            Product p = (Product) sales.get(i);


        }
        return "a";
    }

    public String cancelSale(int cpf){
    return "kk";
    }

}

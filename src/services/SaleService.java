package services;

import data.SaleData;
import entities.Product;
import entities.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;

public class SaleService {

    SaleData saleData = new SaleData();
    List<Object> sales = saleData.listItems();
    public String registerNewSale(Object obj, List<Object> list, LocalDateTime saleDate,int quantity){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        LocalDateTime saleDateFormatted = LocalDateTime.parse(saleDate.format(formatter), formatter);
        Sale sale = new Sale();
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

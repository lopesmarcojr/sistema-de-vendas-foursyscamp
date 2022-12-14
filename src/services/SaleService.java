package services;

import data.SaleData;
import entities.Costumer;
import entities.Product;
import entities.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public class SaleService {

    SaleData saleData = new SaleData();
    List<Object> sales = saleData.listItems();

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

    public String listSales(){
        List<Object> sales = saleData.listItems();
        String returnSales = "--------Vendas--------" + '\n';
        for(int i = 0; i < sales.size(); i++){
            returnSales += sales.get(i);
        }
        return returnSales;
    }



}

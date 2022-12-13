package services;

import data.SaleData;
import entities.Product;
import entities.Sale;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Map;

public class SaleService {

    SaleData saleData = new SaleData();
    List<Object> sales = saleData.listItems();
    public String registerNewSale(LocalDateTime saleDate, List<Product> products, int cpf){
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm");
        String saleDateString = saleDate.format(formatter);
        double totalValue = 0.0;
        for(Product p : products){
            totalValue += p.getPrice();
        }
        Sale sale = new Sale(saleDateString, products, cpf);
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

    public String listSalesByCpf(Map<Integer, Map> map, int cpf){
        String product = "Produto: ";
        for(Map.Entry<Integer,Map> entry : map.entrySet()){
            if(entry.getKey().equals(cpf)){
                product += entry.getValue();
            }
        }
        return product;
    }

    public String cancelSale(int cpf){
    return "kk";
    }

}

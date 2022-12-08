package services;

import data.StockData;
import entities.Product;

import java.util.List;

public class StockService {

    StockData stockData = new StockData();
    List<Object> stock = stockData.listItems();
    public boolean registerNewProduct(String sku, int quantity, String description, double price){
        Product product = new Product(sku, quantity, description, price);
        if(product.getCategory() == null || product.getColor() == null ||
           product.getDepartment() == null || product.getSize() == null ||
           product.getType() == null){
            return false;
        }else{
            stockData.save(product);
        }
        return true;
    }

    public String getStock(){
        String returnStock = "Lista do produto em estoque: " + '\n';
        for(int i = 0; i < stock.size(); i ++){
            Product product = (Product) stock.get(i);
            returnStock += product.toString();
        }
        return returnStock;
    }

    public boolean getItem(String sku){
        Object product = null;
        for(int i = 0; i < stock.size(); i++){
            Product p = (Product) stock.get(i);
            if(p.getSku() == sku){
                product = stock.get(i);
            }
        }
        return true;
    }

    public String removeProduct(int code){
        if(stockData.delete(code)){
            return "Produto removido";
        }
        else{
            return "Produco não localizado";
        }

    }
}

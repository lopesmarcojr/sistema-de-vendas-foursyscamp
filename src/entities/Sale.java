package entities;

import data.StockData;
import services.StockService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;

public class Sale {

    private double totalValue;
    private String saleDate;
    private int cpf;
    private int saleID;

    private Product product;
    private int quantity;
    List<Product> productSold = new ArrayList<>();
    Map<Integer, Map<Object, Integer>> map;

    public Sale(){

    }
        public Sale(String saleDate, Map map, int quantity, Product product) {
        this.saleDate = saleDate;
        this.map = map;
        this.quantity = quantity;
        this.product = product;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public String getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(String saleDate) {
        this.saleDate = saleDate;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public int getSaleID(){ return saleID; }

    public void setSaleID(int saleID){ this.saleID = saleID; }

    public void addProduct(Product product){ productSold.add(product);
    }

    public void deleteProduct(Product product){
        productSold.remove(product);
    }

    @Override
    public String toString() {
        return "Total Value: $" + totalValue + '\n' +
                ", Sale date:" + saleDate + + '\n' +
                ", Costumer identification and bought products: " + map ;
    }
}

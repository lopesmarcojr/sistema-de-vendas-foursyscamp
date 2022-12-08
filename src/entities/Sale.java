package entities;

import data.StockData;
import services.StockService;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Sale {

    private double totalValue;
    private LocalDateTime saleDate;
    private int cpf;
    private int saleID;
    private Costumer costumer;
    List<Product> productSold = new ArrayList<>();

    public Sale(){

    }
    public Sale(LocalDateTime saleDate,Costumer costumer) {
        this.saleDate = saleDate;
        this.costumer = costumer;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue = totalValue;
    }

    public LocalDateTime getSaleDate() {
        return saleDate;
    }

    public void setSaleDate(LocalDateTime saleDate) {
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

}

package entities;

import data.StockData;
import services.StockService;

import java.time.LocalDateTime;
import java.util.*;

public class Sale {

    private double totalValue;
    private String saleDate;
    private int cpf;
    private int saleID;

    private Product product;
    private int quantity;
    List<Product> productSold = new ArrayList<>();

    public Sale(){

    }
        public Sale(String saleDate, List<Product> productSold, int cpf) {
        this.saleDate = saleDate;
        this.productSold = productSold;
        this.cpf = cpf;
    }

    public double getTotalValue() {
        return totalValue;
    }

    public void setTotalValue(double totalValue) {
        this.totalValue += totalValue;
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
                "Sale date: " + saleDate + '\n' +
                "Costumer identification: " + cpf  + '\n' +
                "-------Bought products-------" + '\n' + toStringProducts();
    }

    public String toStringProducts(){
        Set<Product> setProducts = new LinkedHashSet<>();
        setProducts.addAll(productSold);
        productSold.clear();
        productSold.addAll(setProducts);
        String productsList = "";
        for(Product p : productSold){
            productsList += "Product name: " + p.getDescription() + '\n' +
                      "Product price: " + p.getPrice() + '\n' +
                      "Product quantity: " + p.getQuantity() + '\n';
        }
        return productsList;
    }
}

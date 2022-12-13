package entities;

import data.StockData;
import services.StockService;

import java.time.LocalDateTime;
import java.util.*;

public class Sale {

    private double totalValue;
    private String saleDate;
    private int cpf;
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
    public void addProduct(Product product){ productSold.add(product);
    }

    public void deleteProduct(Product product){
        productSold.remove(product);
    }

    @Override
    public String toString() {
        return "Total : R$" + totalValue + '\n' +
                "Data da venda: " + saleDate + '\n' +
                "CPF do cliente: " + cpf  + '\n' +
                "--------Produtos comprados--------" + '\n' + toStringProducts();
    }

    public String toStringProducts(){
        Set<Product> setProducts = new LinkedHashSet<>();
        setProducts.addAll(productSold);
        productSold.clear();
        productSold.addAll(setProducts);
        String productsList = "";
        for(Product p : productSold){
            productsList += "Produto : " + p.getDescription() + '\n' +
                      "Preço : " + p.getPrice() + '\n' +
                      "Quantidade : " + p.getQuantity() + '\n';
        }
        return productsList;
    }
}

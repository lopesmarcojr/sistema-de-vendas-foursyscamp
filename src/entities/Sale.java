package entities;

import data.StockData;
import enums.EnumPayment;
import services.SaleService;
import services.StockService;

import java.time.LocalDateTime;
import java.util.*;

public class Sale {

    private double totalValue;
    private String saleDate;
    private int cpf;
    private String pagamento;
    private SaleService saleService;
    private EnumPayment payment;
    List<Product> productSold = new ArrayList<>();

    public Sale(){

    }
        public Sale(String saleDate, List<Product> productSold, String pagamento, int cpf) {
        this.saleDate = saleDate;
        this.productSold = productSold;
        this.cpf = cpf;
        this.pagamento = pagamento;
        parsePagamento();
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

    public String getPagamento() {
        return pagamento;
    }

    public void parsePagamento() {
        String pPayment = pagamento.substring(0,2);
        this.payment = EnumPayment.getEnumPagamento(pPayment);
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
                "Método de pagamento: " + pagamento + '\n';
    }
}

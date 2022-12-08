package entities;

public class Payment {

    private String paymentType;
    private String paymentData;

    public Payment(){

    }

    public Payment(String paymentType, String paymentData) {
        this.paymentType = paymentType;
        this.paymentData = paymentData;
    }

    public String getPaymentType() {
        return paymentType;
    }

    public void setPaymentType(String paymentType) {
        this.paymentType = paymentType;
    }

    public String getPaymentData() {
        return paymentData;
    }

    public void setPaymentData(String paymentData) {
        this.paymentData = paymentData;
    }
}

package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumPayment {

    CREDIT("CREDIT"),
    DEBIT("DEBIT");


    private static final Map<String, EnumPayment> map = new HashMap<>();
    static {
        for(EnumPayment payment : EnumPayment.values()){
            map.put(payment.paymentMethod, payment);
        }
    }
    String paymentMethod;
    EnumPayment(String paymentMethod){
        this.paymentMethod = paymentMethod;
    }

    private EnumPayment getPaymentMethod(String paymentMethod){
        return map.get(paymentMethod);
    }
}

package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumPayment {

    CREDITO("CRE"),
    DEBITO("DEB"),
    PIX("PIX"),
    DINHEIRO("DIN");


    private static final Map<String, EnumPayment> map = new HashMap<>();
    static {
        for(EnumPayment payment : EnumPayment.values()){
            map.put(payment.getPayment(), payment);
        }
    }
    String payment;
    EnumPayment(String payment){
        this.payment = payment;
    }

    public String getPayment() {
        return payment;
    }

    public static EnumPayment getEnumPagamento(String payment){
        return map.get(payment);
    }
}

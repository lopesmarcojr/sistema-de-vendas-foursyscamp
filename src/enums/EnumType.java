package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumType {

    NACIONAL("N"),
    IMPORTADO("I");

    private static final Map<String, EnumType> mapType = new HashMap<>();
    static {
        for(EnumType type : EnumType.values()){
            mapType.put(type.getCod(), type);
        }
    }
    String cod;

    EnumType(String cod){
        this.cod = cod;
    }

    public String getCod(){
        return cod;
    }

    public static EnumType getEnumType(String cod){
        return mapType.get(cod);
    }
}

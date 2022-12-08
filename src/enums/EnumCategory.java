package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumCategory {

    SHOES("S"),
    CLOTHES("R"),
    PERFUMERY("P"),
    UNDERWAER("I"),
    SPORTS("E");
    static final private Map<String, EnumCategory> map = new HashMap<>();
    static {
        for(EnumCategory category : EnumCategory.values()){
            map.put(category.getAbbrevitation(), category);
        }
    }

    private String abbrevitation;

     EnumCategory(String abbrevitation){
        this.abbrevitation = abbrevitation;
    }

    public String getAbbrevitation() {
        return abbrevitation;
    }

    public static EnumCategory getCategory(String abbrevitation){
         return map.get(abbrevitation);
    }
}

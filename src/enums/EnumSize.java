package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumSize {

    P("P"),
    M("M"),
    G("G");

    private static final Map<String, EnumSize> map = new HashMap<>();
    static {
        for(EnumSize size : EnumSize.values()){
            map.put(size.getSize(), size);
        }
    }
    String size;

    EnumSize(String size){
        this.size = size;
    }

    public String getSize() {
        return size;
    }

    public static EnumSize getSize(String size){
        return map.get(size);
    }
}

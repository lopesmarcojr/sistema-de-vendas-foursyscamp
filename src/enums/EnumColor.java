package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumColor {

    AZUL("AZ","Azul Bebê"),
    AMARELO("AM", "Amarelo Claro"),
    VERDE("VE", "Verde Musgo"),
    VERMELHO("VR", "Vermelho Sangue"),
    PRETO("PR", "Preto Fosco"),
    BRANCO("BR", "Branco Gelo");

    private static final Map<String, EnumColor> mapColor = new HashMap<>();
    static {
        for(EnumColor colors : EnumColor.values()){
            mapColor.put(colors.getColor(), colors);
        }
    }
    private String color;
    private String description;
    EnumColor(String color, String description){
        this.color = color;
        this.description = description;
    }

    public String getColor() {
        return color;
    }

    public String getDescription() {
        return description;
    }

    public static EnumColor getEnumColor(String color){
        return mapColor.get(color);
    }
}

package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumColor {

    BLUE("B","Azul bebê"),
    YELLOW("A", "amarelo claro"),
    GREEN("G", "verde musgo"),
    RED("R", "vermelho sangue"),
    BLACK("BLCK", "preto fosco"),
    WHITE("WHT", "branco gelo");

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

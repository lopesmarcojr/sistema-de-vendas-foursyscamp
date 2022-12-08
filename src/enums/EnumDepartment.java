package enums;

import java.util.HashMap;
import java.util.Map;

public enum EnumDepartment {

    MEN("MAS"),
    WOMEN("FEM"),
    KIDS("INF");

    private static final Map<String, EnumDepartment> map = new HashMap<>();
    static {
        for(EnumDepartment department : EnumDepartment.values()){
            map.put(department.getAbbreviation(), department);
        }
    }
    private String abbreviation;
    EnumDepartment(String abbreviation){
        this.abbreviation = abbreviation;
    }

    public String getAbbreviation() {
        return abbreviation;
    }

    public static EnumDepartment getEnumDepartment(String abbreviation){
        return map.get(abbreviation);
    }
}

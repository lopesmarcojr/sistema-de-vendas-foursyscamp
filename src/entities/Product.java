package entities;

import enums.*;

import java.util.Objects;

public class Product {

    private String sku;
    private int quantity;
    private String description;
    private EnumCategory category;
    private EnumDepartment department;
    private EnumColor color;
    private EnumSize size;
    private EnumType type;

    private double price;


    public Product() {
    }

    public Product(String sku, int quantity, String description, double price) {
        this.sku = sku;
        this.quantity = quantity;
        this.description = description;
        this.price = price;
        parseSku();
    }

    public String getSku() {
        return sku;
    }

    public void setSku(String sku) {
        this.sku = sku;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    public EnumCategory getCategory() {
        return category;
    }

    public void setCategory(EnumCategory category) {
        this.category = category;
    }

    public EnumDepartment getDepartment() {
        return department;
    }

    public void setDepartment(EnumDepartment department) {
        this.department = department;
    }

    public EnumColor getColor() {
        return color;
    }

    public void setColor(EnumColor color) {
        this.color = color;
    }

    public EnumSize getSize() {
        return size;
    }

    public void setSize(EnumSize size) {
        this.size = size;
    }

    public EnumType getType() {
        return type;
    }

    public void setType(EnumType type) {
        this.type = type;
    }

    private void parseSku(){
        String cSize = sku.substring(0,1);
        String cType = sku.substring(1,2);
        String cDept = sku.substring(2,5);
        String cCat = sku.substring(5,6);
        String cColor = sku.substring(6);
        this.size = EnumSize.getSize(cSize);
        this.type = EnumType.getEnumType(cType);
        this.department = EnumDepartment.getEnumDepartment(cDept);
        this.category = EnumCategory.getCategory(cCat);
        this.color = EnumColor.getEnumColor(cColor);

    }
    @Override
    public String toString() {
        return "Produto" +
                " - SKU: " + sku +
                ", Quantidade : " + quantity +
                ", Descrição : " + description +
                ", Preço : " + price + '\n';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Product product = (Product) o;
        return sku.equals(product.sku);
    }

    @Override
    public int hashCode() {
        return Objects.hash(sku);
    }
}

package entities;

import java.util.ArrayList;
import java.util.List;

public class Stock {

    List<Product> product = new ArrayList<>();

    Stock(){

    }

    public void addProduct(Product p){
        product.add(p);
    }

    public void removeProduct(Product p){
        product.remove(p);
    }


}

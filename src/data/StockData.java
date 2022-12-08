package data;

import entities.Product;

import javax.swing.*;
import java.util.ArrayList;
import java.util.List;

public class StockData implements DataInterface {
    static List<Object> stock = new ArrayList<>();

    public void save(Object obj) {
        stock.add(obj);
    }

    public List<Object> listItems() {
        return stock;
    }

    public Object getItem(int code) {
        return null;
    }

    public void update(Object obj) {

    }

    public boolean delete(Object obj) {
        String codigo = (String) obj;
        for(int i = 0; i < stock.size(); i++){
            Product product = (Product) stock.get(i);
            if(product.getSku() == codigo){
                stock.remove(i);
                return true;
            }
        }
        return false;
    }
}

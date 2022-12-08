package data;

import java.util.ArrayList;
import java.util.List;

public class SaleData implements DataInterface {

    List<Object> sale = new ArrayList<>();
    public void save(Object obj) {
        sale.add(obj);
    }

    public void update(Object obj) {

    }

    public boolean delete(Object obj) {
        return false;
    }


    public List<Object> listItems() {
        return sale;
    }


    public Object getItem(int code) {
        return null;
    }
}

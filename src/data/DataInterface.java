package data;

import java.util.List;

public interface DataInterface {

    public void save(Object obj);

    public void update(Object obj);

    public boolean delete(Object obj);

    public List<Object> listItems();

    public Object getItem(int code);


}

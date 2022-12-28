package services;

import data.CostumerData;
import data.SaleData;
import entities.Costumer;
import entities.Product;

import java.util.*;

public class CostumerService {

    CostumerData costumerData = new CostumerData();
    List<Object> costumers = costumerData.listItems();
    Map<Integer,List<Product>> productsBought = new LinkedHashMap<>();
    Set<Product> listProducts = new HashSet<>();
    public String registerNewCostumer(String name, int cpf){
        Costumer costumer = new Costumer(name, cpf);
        costumerData.save(costumer);
        return "Novo cliente cadastrado";
    }

    public String listCostumers(){
        String returnCostumers = "--------Clientes--------" + '\n';
        for(int i = 0; i < costumers.size(); i ++){
            returnCostumers += costumers.get(i);
        }
        return returnCostumers;
    }

    public void addListProductsBought(int cpf,List<Product> objects) {
        listProducts.addAll(objects);
        objects.clear();
        objects.addAll(listProducts);
        productsBought.put(cpf,objects);
    }

    public void costumerProducts(int cpf) {
        System.out.println("---------Produtos---------");
        for(Map.Entry<Integer,List<Product>> entry : productsBought.entrySet()){
            if(cpf == entry.getKey()){
                System.out.println(entry.getValue());
            }
        }
    }
}

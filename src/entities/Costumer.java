package entities;

import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

public class Costumer {

    private String name;
    private int cpf;
    Set<Product> productsBought = new LinkedHashSet<>();
    List<Product> listProducts = new ArrayList<>();

    public Costumer(){

    }

    public Costumer(String name, int cpf) {
        this.name = name;
        this.cpf = cpf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCpf() {
        return cpf;
    }

    public void setCpf(int cpf) {
        this.cpf = cpf;
    }

    public void addListProductsBought(List<Product> objects) {
        productsBought.addAll(objects);
        objects.clear();
        objects.addAll(productsBought);
        listProducts.addAll(objects);
    }

    public String costumerProducts(int cpf) {
        if (cpf == getCpf()) {
            return "--------Produtos--------" + '\n' + listProducts;
        } else {
            return "CPF não encontrado";
        }
    }
}


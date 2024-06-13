package es.ulpgc.eite.da.basic_master_detail;

import java.io.Serializable;
import java.util.List;

public class Category implements Serializable {
    private int id;
    private String name;
    private String description;
    private List<Product> products;

    public Category(int id, String name, String description, List<Product> products) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.products = products;
    }

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public List<Product> getProducts() { return products; }

    @Override
    public String toString() {
        return name;
    }
}
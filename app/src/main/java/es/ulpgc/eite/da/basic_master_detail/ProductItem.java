package es.ulpgc.eite.da.basic_master_detail;

import java.io.Serializable;

public class ProductItem implements Serializable {
    private int id;
    private String name;
    private String description;
    private CategoryItem category;

    public ProductItem(int id, String name, String description) {
        this.id = id;
        this.name = name;
        this.description = description;
    }

    /*
    public Product(int id, String name, String description, Category category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.category = category;
    }
    */

    public int getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public CategoryItem getCategory() { return category; }

    @Override
    public String toString() {
        return name;
    }

    public void setCategory(CategoryItem category) {
        this.category = category;
    }
}
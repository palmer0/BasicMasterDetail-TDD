package es.ulpgc.eite.da.basic_master_detail;

import java.util.ArrayList;
import java.util.List;

public class CatalogRepository {
    private static CatalogRepository instance;
    private List<Category> categories;

    private CatalogRepository() {
        categories = loadCategories();
    }

    public static CatalogRepository getInstance() {
        if (instance == null) {
            instance = new CatalogRepository();
        }
        return instance;
    }

    private List<Category> loadCategories() {
        List<Category> categories = new ArrayList<>();

        // Electronics category
        List<Product> electronicsProducts = new ArrayList<>();
        electronicsProducts.add(new Product(
            1, "Smartphone",
            "Latest model with high resolution camera"
        ));
        electronicsProducts.add(new Product(
            2, "Laptop",
            "High performance laptop for gaming and work"
        ));
        /*electronicsProducts.add(new Product(
            3, "Headphones",
            "Noise-cancelling over-ear headphones"
        ));*/
        Category electronics = new Category(
            1, "Electronics",
            "Electronic items",
            electronicsProducts
        );

        // Books category
        List<Product> booksProducts = new ArrayList<>();
        booksProducts.add(new Product(
            4, "The Great Gatsby",
            "A classic novel by F. Scott Fitzgerald"
        ));
        booksProducts.add(new Product(
            5, "1984",
            "Dystopian novel by George Orwell"
        ));
        booksProducts.add(new Product(
            6, "To Kill a Mockingbird",
            "Novel by Harper Lee"
        ));
        Category books = new Category(
            2, "Books",
            "Various kinds of books",
            booksProducts
        );

        // Fashion category
        List<Product> fashionProducts = new ArrayList<>();
        fashionProducts.add(new Product(
            7, "T-shirt",
            "Cotton T-shirt available in various colors"
        ));
        fashionProducts.add(new Product(
            8, "Jeans",
            "Slim fit jeans for casual wear"
        ));
        fashionProducts.add(new Product(
            9, "Sneakers",
            "Comfortable sneakers for daily use"
        ));
        Category fashion = new Category(
            3, "Fashion",
            "Clothing and accessories",
            fashionProducts
        );

        // Home Appliances category
        List<Product> homeAppliancesProducts = new ArrayList<>();
        homeAppliancesProducts.add(new Product(
            10, "Refrigerator",
            "Energy efficient refrigerator"
        ));
        homeAppliancesProducts.add(new Product(
            11, "Microwave Oven",
            "Compact microwave oven with multiple functions"
        ));
        homeAppliancesProducts.add(new Product(
            12, "Washing Machine",
            "Front load washing machine with quick wash feature"
        ));
        Category homeAppliances = new Category(
            4, "Home Appliances",
            "Appliances for home use",
            homeAppliancesProducts
        );

        // Add categories to list
        categories.add(electronics);
        categories.add(books);
        categories.add(fashion);
        categories.add(homeAppliances);

        // Set category for each product
        for (Product product : electronicsProducts) {
            product.setCategory(electronics);
        }
        for (Product product : booksProducts) {
            product.setCategory(books);
        }
        for (Product product : fashionProducts) {
            product.setCategory(fashion);
        }
        for (Product product : homeAppliancesProducts) {
            product.setCategory(homeAppliances);
        }
        return categories;
    }

    public List<Category> getCategories() {
        return categories;
    }

    public List<Product> getProductsByCategoryId(int categoryId) {
        for (Category category : categories) {
            if (category.getId() == categoryId) {
                return category.getProducts();
            }
        }

        // return empty list if category not found
        return new ArrayList<>();
    }

    public Product getProductById(int productId) {
        for (Category category : categories) {
            for (Product product : category.getProducts()) {
                if (product.getId() == productId) {
                    return product;
                }
            }
        }

        // return null if product not found
        return null;
    }
}

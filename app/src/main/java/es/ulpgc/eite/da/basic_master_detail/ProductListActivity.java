package es.ulpgc.eite.da.basic_master_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListActivity
    extends AppCompatActivity implements View.OnClickListener {

    private RecyclerView productListRecycler;
    private ProductListAdapter productListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_list);
        setTitle(R.string.title_product_list);

        productListRecycler = findViewById(R.id.product_list_recycler);
        productListRecycler.setLayoutManager(new LinearLayoutManager(this));

        /*
        Category category = (Category) getIntent().getSerializableExtra("category");
        List<Product> products = category.getProducts();
        */

        CatalogRepository catalog = CatalogRepository.getInstance();
        int categoryId = getIntent().getIntExtra("category_id", 0);
        List<ProductItem> products = catalog.getProductsByCategoryId(categoryId);

        productListAdapter = new ProductListAdapter(this, products);
        productListRecycler.setAdapter(productListAdapter);
    }

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ProductDetailActivity.class);
        ProductItem product = (ProductItem) view.getTag();
        //intent.putExtra("product", product);
        intent.putExtra("product_id", product.getId());
        startActivity(intent);
    }
}

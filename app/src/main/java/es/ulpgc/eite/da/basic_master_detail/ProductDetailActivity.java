package es.ulpgc.eite.da.basic_master_detail;

import android.os.Bundle;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView productNameTextView;
    private TextView productDescrTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setTitle(R.string.title_product_detail);

        productNameTextView = findViewById(R.id.product_name);
        productDescrTextView = findViewById(R.id.product_description);

        //Product product = (Product) getIntent().getSerializableExtra("product");

        CatalogRepository catalog = CatalogRepository.getInstance();
        int productId = getIntent().getIntExtra("product_id", 0);
        Product product = catalog.getProductById(productId);

        productNameTextView.setText(product.getName());
        productDescrTextView.setText(product.getDescription());
    }
}

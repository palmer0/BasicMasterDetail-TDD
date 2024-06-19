package es.ulpgc.eite.da.basic_master_detail;

import android.os.Bundle;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailActivity extends AppCompatActivity {

    private TextView productNameTextView;
    private TextView productDescrTextView;

    //private ImageButton favoriteButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_detail);
        setTitle(R.string.title_product_detail);

        productNameTextView = findViewById(R.id.product_name);
        productDescrTextView = findViewById(R.id.product_description);
        //favoriteButton = findViewById(R.id.favorite_button);

        /*
        ProductItem product =
            (ProductItem) getIntent().getSerializableExtra("product");
        */

        CatalogRepository catalog = CatalogRepository.getInstance();
        int productId = getIntent().getIntExtra("product_id", 0);
        ProductItem product = catalog.getProductById(productId);

        productNameTextView.setText(product.getName());
        productDescrTextView.setText(product.getDescription());
        //favoriteButton.setImageResource(R.drawable.ic_red_heart);
        //favoriteButton.setImageResource(R.drawable.ic_black_heart);
    }
}

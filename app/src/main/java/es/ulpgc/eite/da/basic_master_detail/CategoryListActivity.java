package es.ulpgc.eite.da.basic_master_detail;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryListActivity extends AppCompatActivity {

    private List<CategoryItem> categories;
    private RecyclerView categoryListRecycler;
    private CategoryListAdapter categoryListAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category_list);
        setTitle(R.string.title_category_list);

        categoryListRecycler = findViewById(R.id.category_list_recycler);
        categoryListRecycler.setLayoutManager(new LinearLayoutManager(this));

        CatalogRepository catalog = CatalogRepository.getInstance();
        categories = catalog.getCategories();
        categoryListAdapter = new CategoryListAdapter(this, categories);
        categoryListRecycler.setAdapter(categoryListAdapter);
    }

}

package es.ulpgc.eite.da.basic_master_detail;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CategoryListActivity
    extends AppCompatActivity implements View.OnClickListener {

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

    @Override
    public void onClick(View view) {
        Intent intent = new Intent(this, ProductListActivity.class);
        CategoryItem category = (CategoryItem) view.getTag();
        //intent.putExtra("category", category);
        intent.putExtra("category_id", category.getId());
        startActivity(intent);
    }
}

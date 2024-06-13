package es.ulpgc.eite.da.basic_master_detail;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ProductListAdapter
    extends RecyclerView.Adapter<ProductListAdapter.ViewHolder> {

    private List<ProductItem> productList;
    private ProductListActivity parentActivity;

    public ProductListAdapter(
        ProductListActivity activity, List<ProductItem> products
    ) {
        parentActivity = activity;
        productList = products;
    }


    public void addItems(List<ProductItem> products) {
        productList.addAll(products);
        notifyDataSetChanged();
    }

    public void setItems(List<ProductItem> products) {
        productList.clear();
        productList.addAll(products);
        notifyDataSetChanged();
    }

    public void addItem(ProductItem product) {
        productList.add(product);
        notifyDataSetChanged();
    }


    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater
            .from(parent.getContext())
            .inflate(R.layout.item_product, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        ProductItem product = productList.get(position);
        holder.productName.setText(product.getName());
        holder.itemView.setOnClickListener(v -> {
            Intent intent = new Intent(parentActivity, ProductDetailActivity.class);
            //intent.putExtra("product", product);
            intent.putExtra("product_id", product.getId());
            parentActivity.startActivity(intent);
        });
    }

    @Override
    public long getItemId(int position) {
        ProductItem product = productList.get(position);
        return product.getId();
    }

    public ProductItem getItem(int position) {
        return productList.get(position);
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }


    public static class ViewHolder extends RecyclerView.ViewHolder {
        public TextView productName;

        public ViewHolder(View itemView) {
            super(itemView);
            productName = itemView.findViewById(R.id.product_name);
        }
    }
}

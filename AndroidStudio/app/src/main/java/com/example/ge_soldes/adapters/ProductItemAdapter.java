package com.example.ge_soldes.adapters;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.ge_soldes.R;
import com.example.ge_soldes.models.ProductItem;
import com.example.ge_soldes.models.ProductItem;

import java.util.List;

public class ProductItemAdapter extends BaseAdapter {

    private Context context;
    private List<ProductItem> productItemList;
    private LayoutInflater inflater;

    public ProductItemAdapter(Context context, List<ProductItem> productItemList){

        this.context = context;
        this.productItemList = productItemList;
        this.inflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return productItemList.size();
    }

    @Override
    public ProductItem getItem(int position) {
        return productItemList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        view = inflater.inflate(R.layout.adapter_item,null);

        ProductItem currentItem = getItem(i);
        String itemName = currentItem.getNom_produit();
        String itemAdresse = currentItem.getAdresse();
        String itemPriceBase = currentItem.getPrix_base();
        String itemPriceSolde = currentItem.getPrix_solde();
        String itemDateAjout = currentItem.getDate_ajout();

        ImageView itemIconView = view.findViewById(R.id.item_icon);
        String resourceName = itemName;
        int resId = context.getResources().getIdentifier(resourceName, "drawable",context.getPackageName());
        itemIconView.setImageResource(resId);
        TextView itemNameView = view.findViewById(R.id.item_name);
        itemNameView.setText(itemName);

        TextView itemPriceView = view.findViewById(R.id.item_price);
        itemPriceView.setText(itemPriceSolde + " CHF");

        return view;
    }
}

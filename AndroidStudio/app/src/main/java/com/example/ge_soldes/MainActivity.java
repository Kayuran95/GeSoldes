package com.example.ge_soldes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ListView;

import com.example.ge_soldes.adapters.ProductItemAdapter;
import com.example.ge_soldes.models.ProductItem;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //liste des items
        List<ProductItem> ProductItemList = new ArrayList<>();
        ProductItemList.add(new ProductItem("mars","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));
        ProductItemList.add(new ProductItem("pizza","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));
        ProductItemList.add(new ProductItem("choco75","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));

        ListView productListView = findViewById(R.id.product_list_view);
        productListView.setAdapter(new ProductItemAdapter(this,ProductItemList));
    }
}
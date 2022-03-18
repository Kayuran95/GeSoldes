package com.example.ge_soldes;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;

import com.example.ge_soldes.adapters.ProductItemAdapter;
import com.example.ge_soldes.models.ProductItem;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;


import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ListView productListView = findViewById(R.id.product_list_view);

        new FirebaseDatabaseHelper().readProduits(new FirebaseDatabaseHelper.DataStatus() {


            @Override
            public void DataIsLoaded(List<ProductItem> produits, List<String> keys) {

            }

            @Override
            public void DataIsInserted() {

            }

            @Override
            public void DataIsUpdated() {

            }

            @Override
            public void DataIsDeleted() {

            }
        });
        //liste des items
        List<ProductItem> ProductItemList = new ArrayList<>();
        ProductItemList.add(new ProductItem("mars","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));
        ProductItemList.add(new ProductItem("pizza","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));
        ProductItemList.add(new ProductItem("choco75","Barre Mars - COOP", "2.50", "1.95", "17/03/22"));


        productListView.setAdapter(new ProductItemAdapter(this,ProductItemList));
    }


}


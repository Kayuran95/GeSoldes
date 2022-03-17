package com.example.ge_soldesv2;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mRecyclerView = (RecyclerView) findViewById(R.id.RecyclerView_produits);
        new FirebaseDatabaseHelper().readProduits(new FirebaseDatabaseHelper.DataStatus() {
            @Override
            public void DataIsLoaded(List<Produits> produits, List<String> keys) {
                new RecyclerView_Config().setConfig(mRecyclerView,MainActivity.this,produits,keys);

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
    }
}
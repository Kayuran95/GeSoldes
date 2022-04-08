package com.example.ge_soldesv2;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import java.util.List;

public class MainActivity extends AppCompatActivity  {


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

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu,menu);
        return super.onCreateOptionsMenu(menu);
    }


    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()){
            case R.id.ajout_menu:
                startActivity(new Intent(this,NewProductActivity.class));
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


}
package com.example.ge_soldesv2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.List;

public class NewProductActivity extends AppCompatActivity {

    private EditText mProduit_editText;
    private EditText mDateAjout_editText;
    private EditText mAdresse_editText;
    private EditText mPrixbase_editText;
    private EditText mPrixsolde_editText;
    private Button mbtn_Ajouter;
    private Button mbtn_Retour;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_product);

        mProduit_editText = (EditText) findViewById(R.id.produit_editText);
        mDateAjout_editText = (EditText) findViewById(R.id.dateAjout_editText);
        mAdresse_editText = (EditText) findViewById(R.id.adresse_editText);
        mPrixbase_editText = (EditText) findViewById(R.id.prixbase_editText);
        mPrixsolde_editText = (EditText) findViewById(R.id.prixsolde_editText);

        mbtn_Ajouter = (Button) findViewById(R.id.btn_ajouter);
        mbtn_Retour = (Button) findViewById(R.id.btn_retour);

        mbtn_Ajouter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Produits produits = new Produits();
                produits.setNom_produit(mProduit_editText.getText().toString());
                produits.setDate_ajout(mDateAjout_editText.getText().toString());
                produits.setAdresse(mAdresse_editText.getText().toString());
                produits.setPrix_base(mPrixbase_editText.getText().toString());
                produits.setPrix_solde(mPrixsolde_editText.getText().toString());

                new FirebaseDatabaseHelper().addProduit(produits, new FirebaseDatabaseHelper.DataStatus() {
                    @Override
                    public void DataIsLoaded(List<Produits> produits, List<String> keys) {

                    }

                    @Override
                    public void DataIsInserted() {
                        Toast.makeText(NewProductActivity.this,"Le produit a été ajouté.",Toast.LENGTH_LONG).show();
                    }

                    @Override
                    public void DataIsUpdated() {

                    }

                    @Override
                    public void DataIsDeleted() {

                    }
                });

                mbtn_Retour.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        finish();
                        return;
                    }
                });

            }
        });
    }
}
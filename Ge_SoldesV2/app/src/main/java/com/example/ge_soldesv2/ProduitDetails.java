package com.example.ge_soldesv2;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.storage.FirebaseStorage;
import com.squareup.picasso.Picasso;

public class ProduitDetails extends AppCompatActivity {

    private Button mbtn_Retour;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.produits_details);

        Intent intent = getIntent();
        if (intent != null){
            String nom = "";
            String prix_base = "";
            String prix_solde = "";
            String adresse = "";
            String image = "";


            if (intent.hasExtra("nom")){
                nom = intent.getStringExtra("nom");
            } if (intent.hasExtra("prixBase")){
                prix_base = intent.getStringExtra("prixBase");
            }if (intent.hasExtra("prixSolde")){
                prix_solde = intent.getStringExtra("prixSolde");
            }if (intent.hasExtra("adresse")){
                adresse = intent.getStringExtra("adresse");
            }if (intent.hasExtra("image")){
                image = intent.getStringExtra("image");
            }

            TextView textViewNom = (TextView) findViewById(R.id.textView_detailNomProduit);
            textViewNom.setText(nom);
            TextView textViewPrixBase = (TextView) findViewById(R.id.textView_Details_PrixBase);
            textViewPrixBase.setText(prix_base);
            TextView textViewPrixSolde = (TextView) findViewById(R.id.textView_Details_PrixSolde);
            textViewPrixSolde.setText(prix_solde);
            TextView textViewAdresse = (TextView) findViewById(R.id.textView_Details_Adresse);
            textViewAdresse.setText(adresse);

           ImageView imageView= (ImageView) findViewById(R.id.imageView_details);
            FirebaseStorage.getInstance().getReference().child("Produit").child(image).getDownloadUrl().addOnSuccessListener(new OnSuccessListener<Uri>() {
                @Override
                public void onSuccess(Uri uri) {
                    Picasso.get().load(uri).fit().centerCrop().into(imageView);
                }
            });

            mbtn_Retour = (Button) findViewById(R.id.button_retour2);


            mbtn_Retour.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    finish();
                }
            });
        }
    }
}
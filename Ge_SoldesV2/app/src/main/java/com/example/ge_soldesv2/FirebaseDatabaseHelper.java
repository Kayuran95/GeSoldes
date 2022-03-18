package com.example.ge_soldesv2;

import androidx.annotation.NonNull;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;
import java.util.List;


public class FirebaseDatabaseHelper {

    private FirebaseDatabase mDatabase;
    private DatabaseReference mReferenceProduits;
    private List<Produits> produits = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<Produits> produits, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated ();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance("https://ge-soldes-963b1-default-rtdb.europe-west1.firebasedatabase.app");
        mReferenceProduits = mDatabase.getReference("produit");
    }

    public void readProduits(final DataStatus dataStatus){
        mReferenceProduits.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                produits.clear();
                List<String> keys = new ArrayList<>();
                for (DataSnapshot keyNode : dataSnapshot.getChildren()){
                    keys.add(keyNode.getKey());
                    Produits produit = keyNode.getValue(Produits.class);
                    produits.add(produit);
                }
                dataStatus.DataIsLoaded(produits,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

    public void addProduit(Produits produits, final DataStatus dataStatus){
        String key = mReferenceProduits.push().getKey();
        mReferenceProduits.child(key).setValue(produits)
                .addOnSuccessListener(new OnSuccessListener<Void>() {
                    @Override
                    public void onSuccess(Void unused) {
                        dataStatus.DataIsInserted();
                    }
                });
    }

}

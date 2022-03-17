package com.example.ge_soldes;

import androidx.annotation.NonNull;

import com.example.ge_soldes.models.ProductItem;
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
    private List<ProductItem> produits = new ArrayList<>();

    public interface DataStatus{
        void DataIsLoaded(List<ProductItem> produits, List<String> keys);
        void DataIsInserted();
        void DataIsUpdated ();
        void DataIsDeleted();
    }

    public FirebaseDatabaseHelper(){
        mDatabase = FirebaseDatabase.getInstance();
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
                    ProductItem produit = keyNode.getValue(ProductItem.class);
                    produits.add(produit);
                }
                dataStatus.DataIsLoaded(produits,keys);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {

            }
        });
    }

}

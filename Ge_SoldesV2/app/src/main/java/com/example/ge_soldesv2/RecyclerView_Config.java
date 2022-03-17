package com.example.ge_soldesv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class RecyclerView_Config {
    private Context mContext;
    private ProduitsAdapter mProduitsAdapter;

    public void setConfig (RecyclerView recyclerView, Context context, List<Produits> produits, List<String> keys){

        mContext = context;
        mProduitsAdapter = new ProduitsAdapter(produits, keys);
        recyclerView.setLayoutManager(new LinearLayoutManager(context));
        recyclerView.setAdapter(mProduitsAdapter);

    }


    class ProduitItemView extends RecyclerView.ViewHolder{
        private TextView mNom_Produit;
        private TextView mPrix_Base;
        private TextView mPrix_solde;
        private TextView mAdresse;
        private String key;

        public ProduitItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.produits_view,parent,false));

            mNom_Produit = (TextView) itemView.findViewById(R.id.nom_produit_textView);
            mPrix_Base = (TextView) itemView.findViewById(R.id.prix_base_TextView);
            mPrix_solde = (TextView) itemView.findViewById(R.id.prix_solde_TextView);
            mAdresse = (TextView) itemView.findViewById(R.id.adresse_textView);

        }

        public void bind( Produits produits,  String key){
            mNom_Produit.setText(produits.getNom_produit());
            mPrix_Base.setText(produits .getPrix_base());
            mPrix_solde.setText(produits.getPrix_solde());
            mAdresse.setText(produits.getAdresse());
            this.key=key;
        }
    }
    class ProduitsAdapter extends RecyclerView.Adapter<ProduitItemView>{
        private List<Produits> mProduitList ;
        private List<String> mKeys;

        public ProduitsAdapter(List<Produits> mProduitList, List<String> mKeys) {
            this.mProduitList = mProduitList;
            this.mKeys = mKeys;
        }

        @NonNull
        @Override
        public ProduitItemView onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
            return new ProduitItemView(parent);
        }

        @Override
        public void onBindViewHolder(@NonNull ProduitItemView holder, int position) {
            holder.bind(mProduitList.get(position), mKeys.get(position));
        }

        @Override
        public int getItemCount() {
            return mProduitList.size();
        }
    }
}

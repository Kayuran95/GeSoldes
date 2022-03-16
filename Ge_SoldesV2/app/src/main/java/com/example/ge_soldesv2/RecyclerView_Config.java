package com.example.ge_soldesv2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

public class RecyclerView_Config {
    private Context mContext;

    class ProduitItemView extends RecyclerView.ViewHolder{
        private TextView mNom_Produit;
        private TextView mPrix_Base;
        private TextView mPrix_solde;
        private TextView mAdresse;

        private String key;

        public ProduitItemView(ViewGroup parent){
            super(LayoutInflater.from(mContext).inflate(R.layout.produits_view,parent,false));

            mNom_Produit = (TextView) itemView.findViewById(R.id.nom_produit_textView);

        }
    }
}

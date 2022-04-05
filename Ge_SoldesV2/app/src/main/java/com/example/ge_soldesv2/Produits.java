package com.example.ge_soldesv2;

public class Produits {
    private String nom_produit;
    private String adresse;
    private String prix_base;
    private String prix_solde;
    private String date_ajout;
    private String image_adresse;

    public Produits() {
    }

    public Produits(String nom_produit, String adresse, String prix_base, String prix_solde, String date_ajout, String image_adresse) {
        this.nom_produit = nom_produit;
        this.adresse = adresse;
        this.prix_base = prix_base;
        this.prix_solde = prix_solde;
        this.date_ajout = date_ajout;
        this.image_adresse = image_adresse;
    }

    public String getNom_produit() {
        return nom_produit;
    }

    public void setNom_produit(String nom_produit) {
        this.nom_produit = nom_produit;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getPrix_base() {
        return prix_base;
    }

    public void setPrix_base(String prix_base) {
        this.prix_base = prix_base;
    }

    public String getPrix_solde() {
        return prix_solde;
    }

    public void setPrix_solde(String prix_solde) {
        this.prix_solde = prix_solde;
    }

    public String getDate_ajout() {
        return date_ajout;
    }

    public void setDate_ajout(String date_ajout) {
        this.date_ajout = date_ajout;
    }

    public void setImage_adresse(String image_adresse) { this.image_adresse = image_adresse; }

    public String getImage_adresse() { return image_adresse; }


}

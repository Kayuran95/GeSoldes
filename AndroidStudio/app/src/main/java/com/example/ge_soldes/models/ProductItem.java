package com.example.ge_soldes.models;

public class ProductItem {
    private String name;
    private String mneminic;
    private double price;

    public ProductItem(String name, String mneminic, double price){
        this.name = name;
        this.mneminic = mneminic;
        this.price = price;
    }

    public String getName(){return name;}

    public String getMneminic(){return mneminic;}

    public double getPrice(){return price;}
}

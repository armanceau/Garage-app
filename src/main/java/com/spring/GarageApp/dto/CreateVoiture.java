package com.spring.GarageApp.dto;


public class CreateVoiture {
       
	private String modele;

    private String marque;

    private Float prix;

    public CreateVoiture(String modele, String marque, Float prix) {
        this.modele = modele;
        this.marque = marque;
        this.prix = prix;
    }

    public String getModele() {
        return modele;
    }

    public String getMarque() {
        return marque;
    }

    public Float getPrix() {
        return prix;
    }
}

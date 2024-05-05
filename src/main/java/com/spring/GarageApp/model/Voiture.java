package com.spring.GarageApp.model;

import jakarta.persistence.*;

@Entity
public class Voiture {
    
    @Id
	@GeneratedValue(strategy = GenerationType.UUID)
	private String uuid;

    @Column(
		length = 25
	)
	private String modele;

    private String marque;

    private Float prix;


    public Voiture() {
    }

    public Voiture(String modele, String marque, Float prix) {
        this.modele = modele;
        this.marque = marque;
        this.prix = prix;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Float getPrix() {
        return prix;
    }

    public void setPrix(Float prix) {
        this.prix = prix;
    }


}

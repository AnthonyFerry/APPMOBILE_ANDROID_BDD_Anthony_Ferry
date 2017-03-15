package com.example.anthonyferry.appmobile_android_bdd_anthony_ferry;

/**
 * Created by Anthony FERRY on 15/03/2017.
 */

public class Chapitre {
    private int id;
    private String nom;
    private String description;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Nom du chapitre = " + nom + "\n" + "Description du chapitre = " + description);
        return sb.toString();
    }
}

package com.example.toyo.barcodereader;


public class Utilisateur {

    private String nom;
    private String mdp;

    public Utilisateur(String nom, String mdp) {
        this.nom = nom;
        this.mdp = nom;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getmdp(){
        return mdp;
    }

    public void setMdp(String mdp){
        this.mdp = mdp;
    }
}

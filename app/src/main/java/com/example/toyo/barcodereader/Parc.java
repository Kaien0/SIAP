package com.example.toyo.barcodereader;

import android.content.Context;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 12/09/2016.
 */
public class Parc {
    private String id, nom, id_formulaire, id_site;
    private Context ctx;
    private Formulaire formulaire;
    ArrayList<Jeu> LST_jeu;

    public Parc(Context ctx, String id){
        this.ctx = ctx;
        this.id = id;
        String result = "";
        String[] LST_result = null;
        LST_jeu = new ArrayList<Jeu>();

        ConstructeurParc parc = new ConstructeurParc(ctx);
        try {
            result = parc.execute(id).get();
            LST_result = result.split("<br/>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        if (LST_result != null){
            id = LST_result[0];
            nom = LST_result[1];
            id_formulaire = LST_result[2];
            id_site = LST_result[3];
            for (int i = 4; i < LST_result.length; i++){
                LST_jeu.add(new Jeu(ctx, LST_result[i]));
            }
            formulaire = new Formulaire(ctx, id);
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId_formulaire() {
        return id_formulaire;
    }

    public void setId_formulaire(String id_formulaire) {
        this.id_formulaire = id_formulaire;
    }

    public String getId_site() {
        return id_site;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }

    public Formulaire getFormulaire() {
        return formulaire;
    }

    public void setFormulaire(Formulaire formulaire) {
        this.formulaire = formulaire;
    }

    public ArrayList<Jeu> getLST_jeu(){
        return LST_jeu;
    }

    public Jeu getJeu(int index){
        return LST_jeu.get(index);
    }
}

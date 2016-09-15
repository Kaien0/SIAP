package com.example.toyo.barcodereader;

import android.content.Context;

import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 12/09/2016.
 */
public class Jeu {
    private String id, nom, id_formulaire, id_parc;
    private Context ctx;
    private Formulaire formulaire;

    public Jeu(Context ctx, String id){
        this.ctx = ctx;
        this.id = id;
        String result = "";
        String[] LST_result = null;

        constructeurJeu jeu = new constructeurJeu(ctx);
        try {
            result = jeu.execute(id).get();
            LST_result = result.split("<br/>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if (LST_result != null){
            id = LST_result[0];
            nom = LST_result[1];
            id_parc = LST_result[2];
            id_formulaire = LST_result[3];
        }
        formulaire = new Formulaire(ctx, id);
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

    public String getId_parc() {
        return id_parc;
    }

    public void setId_parc(String id_parc) {
        this.id_parc = id_parc;
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
}

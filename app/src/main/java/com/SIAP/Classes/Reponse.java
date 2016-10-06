package com.SIAP.Classes;

import android.content.Context;

import com.SIAP.Classes.AsyncTaskConstructeur.ConstructeurReponse;

import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 11/09/2016.
 */
public class Reponse {
    private String nom, texte;
    private String id;
    Context ctx;

    public Reponse(Context ctx, String id_rep) {
        this.ctx = ctx;
        final ConstructeurReponse repTask = new ConstructeurReponse(ctx);

        String geet = null;
        String[] TAB_reponse = null;

        try {
            geet = repTask.execute(id_rep).get();
            TAB_reponse = geet.split("<br/>");

            id = TAB_reponse[0];
            nom = TAB_reponse[1];
            texte = TAB_reponse[2];
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }





    }


    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}


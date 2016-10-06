package com.SIAP.Classes;

import android.content.Context;

import com.SIAP.Classes.AsyncTaskConstructeur.ConstructeurAgent;

import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 12/09/2016.
 */
public class Agent {
    private String id, nom, mdp;
    private Context ctx;

    public Agent(Context ctx, String id){
        this.ctx = ctx;
        this.id = id;
        String result = "";
        String[] LST_result = null;

        ConstructeurAgent agent = new ConstructeurAgent(ctx);
        try {
            result = agent.execute(id).get();
            LST_result = result.split("<br/>");
            id = LST_result[0];
            nom = LST_result[1];
            mdp = LST_result[2];
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
    }

    //Finir constructeur
    /*public Agent(String nom, String mdp, Context ctx){
        this.ctx = ctx;
        GestionBD db = new GestionBD(ctx);
        this.nom = nom;
        this.mdp = mdp;
        Cursor c = db.constructeurAgent(this);
       // c.moveToFirst();
        this.id = c.getColumnName(0);
    }*/

    public Agent(String nom, String mdp){
        this.nom = nom;
        this.mdp = mdp;
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

    public String getMdp() {
        return mdp;
    }

    public void setMdp(String mdp) {
        this.mdp = mdp;
    }

    public Context getCtx() {
        return ctx;
    }

    public void setCtx(Context ctx) {
        this.ctx = ctx;
    }
}

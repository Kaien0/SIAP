package com.example.toyo.barcodereader;

import android.content.Context;
import android.util.Log;

import java.util.ArrayList;
import java.util.Collection;
import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 11/09/2016.
 */
public class Question {
   private ArrayList<Reponse> LST_reponse;
    private String id;
    private String nom;
    private String texte;
    private Context ctx;
   // private Context ctxQ;


   /* public  Question(int id_quest, Context ctx){
        id = id_quest;
        this.ctxQ = ctx;
        BackgroundTask bg = new BackgroundTask(this.ctxQ);
        bg.execute("constructQuestion", String.valueOf(id));
    }*/


    public Question(Context ctx, String id) {
        final BackgroundTask recupQuestions = new BackgroundTask(ctx);
        String geet;
        String questt;
        String[] EXTRA_TabQuest;
        String EXTRA_TabConstructQuestion = null;

        try {
            geet = recupQuestions.execute("constructeurQuestion", id).get();
            EXTRA_TabQuest = geet.split("<br/>");
            this.id = EXTRA_TabQuest[0];
            this.nom = EXTRA_TabQuest[1];
            this.texte = EXTRA_TabQuest[2];
            LST_reponse = new ArrayList<Reponse>();

            int r = 3;
            while(r < EXTRA_TabQuest.length)
            {
                LST_reponse.add(new Reponse(ctx, EXTRA_TabQuest[r]));
                Log.d("ARRAYLISTREPONSE", LST_reponse.get(r-3).getTexte());
                r++;
            }

        } catch (InterruptedException e1) {
            e1.printStackTrace();
        } catch (ExecutionException e1) {
            e1.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e2){
            e2.printStackTrace();
        }catch (IndexOutOfBoundsException e){
            e.printStackTrace();
        }

        Log.d("CONSTRUCTQUESTION", "FIN CONSTRUCT QUESTION");
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getTexte() {
        return texte;
    }

    public void setTexte(String texte) {
        this.texte = texte;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public ArrayList<Reponse> getLST_reponse() {

        return LST_reponse;
    }
    public Reponse getReponse(int r) {
        if (r < LST_reponse.size()){
            return LST_reponse.get(r);
        }
        return null;
    }

}

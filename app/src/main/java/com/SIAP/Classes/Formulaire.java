package com.SIAP.Classes;

import android.content.Context;

import com.SIAP.Classes.AsyncTaskConstructeur.ConstructeurFormulaire;

import java.util.ArrayList;
import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 12/09/2016.
 */
public class Formulaire {
    private String id = "", nom = "", id_version_precedente = "";
    private ArrayList<Question> LST_question;
    private int indice = 0;
    Context ctx;

    public Formulaire(Context ctx, String id){
        this.id = id;
        this.ctx = ctx;
        String reponse = "";
        String[] LST_reponse = null;
        LST_question = new ArrayList<Question>();

        ConstructeurFormulaire form = new ConstructeurFormulaire(ctx);
        try {
            reponse = form.execute("2").get();
            LST_reponse = reponse.split("<br/>");
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

        if(LST_reponse != null){
            id = LST_reponse[0];
            nom = LST_reponse[1];
            id_version_precedente = LST_reponse[2];
            for(int i = 3; i < LST_reponse.length; i++){
           // LST_question.add(new Question(ctx, LST_reponse[i]));
            }
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

    public String getId_version_precedente() {
        return id_version_precedente;
    }

    public void setId_version_precedente(String id_version_precedente) {
        this.id_version_precedente = id_version_precedente;
    }

    public void setLST_question(ArrayList<Question> LST_question) {
        this.LST_question = LST_question;
    }

    public ArrayList<Question> getLST_question(){
        return LST_question;
    }

    public Question getQuestion(int index){
        return LST_question.get(index);
    }

    public int getIndice() {
        return indice;
    }

    public void setIndice(int indice) {
        this.indice = indice;
    }
}

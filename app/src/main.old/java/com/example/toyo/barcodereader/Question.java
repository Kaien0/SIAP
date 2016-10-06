package com.example.toyo.barcodereader;

import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by bashark on 11/09/2016.
 */
public class Question {
    private ArrayList<Reponse> LST_reponse;
    String nom, texte;
    private int id;

    public void Question(int id_quest){
        id = id_quest;

    }
}

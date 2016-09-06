package com.example.toyo.barcodereader;


import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class GestionBD {
    private SQLiteDatabase db;
    private BdHelper bdH;

    public GestionBD(Context context){
        bdH = new BdHelper(context, "BaseSIAP", null, 1);
        init();
    }
    private void init(){



    }

    public void open(){
        db = bdH.getWritableDatabase();
    }

    public void close(){
        db.close();
    }

    public long ajouterUser(Utilisateur user){
        ContentValues v = new ContentValues();
        v.put("nom", user.getNom());
        v.put("mdp", user.getmdp());
        return db.insert("utilisateur", null, v);
    }


}

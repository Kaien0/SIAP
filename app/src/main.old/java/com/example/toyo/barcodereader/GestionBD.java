package com.example.toyo.barcodereader;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.SIAP.BDD.SQLite.BdHelper;


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

    public void read(){
        db = bdH.getReadableDatabase();
    }

    public void close(){
        db.close();
    }

    public Cursor RecupererToutUser(){
        String[] user = new String[]{"_id", "motdepasse"};
        String req = "SELECT * FROM utilisateur;";
        Cursor c = db.rawQuery(req, null);
        return c;
    }

    public long ajouterUser(Utilisateur user){
        ContentValues v = new ContentValues();
        v.put("_id", user.getNom());
        v.put("motdepasse", user.getmdp());
        return db.insert("utilisateur", null, v);
    }


}

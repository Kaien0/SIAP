package com.SIAP.BDD.SQLite;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.SIAP.Classes.Agent;


public class GestionBD {
    private SQLiteDatabase db;
    private BdHelper bdH;

    public GestionBD(Context context){
        bdH = new BdHelper(context, "BaseSIAP", null, 2);
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
        String req = "SELECT * FROM agent;";
        Cursor c = db.rawQuery(req, null);
        return c;
    }

    public long ajouterAgent(Agent agent){
        ContentValues v = new ContentValues();
        v.put("nom_agent", agent.getNom());
        v.put("mdp_agent", agent.getMdp());
        return db.insert("agent", null, v);
    }

    /*public Cursor constructeurAgent(Agent agent){
        String req = "SELECT _id, nom_agent, mdp_agent FROM agent WHERE nom_agent=\""+agent.getNom()+"\" AND mdp_agent=\""+agent.getMdp()+"\";";
        Cursor c = db.rawQuery(req, null);
        return c;
    }*/

    public int login(String nom, String mdp){
        String req = "SELECT nom_agent, mdp_agent FROM agent WHERE nom_agent=\""+nom+"\" AND mdp_agent=\""+mdp+"\";";
        Cursor c = db.rawQuery(req, null);
        if(c.moveToFirst())
            return 1;
        else
            return 0;
    }

}

package com.SIAP.BDD.SQLite;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper{

    public BdHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String agent = "CREATE TABLE agent(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_agent TEXT, mdp_agent TEXT)";
        final String controle = "CREATE TABLE controle(_id INTEGER PRIMARY KEY AUTOINCREMENT, date_controle DATE, id_agent INTEGER, id_parc INTEGER, id_jeu INTEGER," +
                " id_formulaire INTEGER, id_question INTEGER, id_reponse INTEGER)";
        final String formulaire = "CREATE TABLE formulaire(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_formulaire TEXT, id_version_precedente INTEGER)";
        final String jeu = "CREATE TABLE jeu(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_jeu TEXT, id_formulaire INTEGER id_parc INTEGER)";
        final String liaisonFQ = "CREATE TABLE liaisonFQ(_id INTEGER PRIMARY KEY AUTOINCREMENT, id_formulaire INTEGER, id_question INTEGER, rang INTEGER)";
        final String liaisonQR = "CREATE TABLE liaisonQR(_id INTEGER PRIMARY KEY AUTOINCREMENT, id_question INTEGER, id_reponse INTEGER, rang INTEGER)";
        final String parc = "CREATE TABLE parc(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_parc TEXT, id_formulaire INTEGER, id_site INTEGER)";
        final String question = "CREATE TABLE question(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_question TEXT, texte_question TEXT)";
        final String reponse = "CREATE TABLE reponse(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_reponse TEXT, texte_reponse TEXT)";
        final String site = "CREATE TABLE site(_id INTEGER PRIMARY KEY AUTOINCREMENT, nom_site TEXT, adresse_site TEXT, cp_site TEXT, ville_site TEXT)";
        db.execSQL(agent);
        db.execSQL(controle);
        db.execSQL(formulaire);
        db.execSQL(jeu);
        db.execSQL(liaisonFQ);
        db.execSQL(liaisonQR);
        db.execSQL(parc);
        db.execSQL(question);
        db.execSQL(reponse);
        db.execSQL(site);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String req = "DROP TABLE IF EXISTS utilisateur;";
        onCreate(db);
    }
}

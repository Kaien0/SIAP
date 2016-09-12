package com.example.toyo.barcodereader;


import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BdHelper extends SQLiteOpenHelper{

    public BdHelper (Context context, String name, SQLiteDatabase.CursorFactory factory, int version){
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        final String req = "CREATE TABLE utilisateur(id integer primary key autoincrement, _id, motdepasse)";
        db.execSQL(req);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        final String req = "DROP TABLE IF EXISTS utilisateur;";
        onCreate(db);
    }
}

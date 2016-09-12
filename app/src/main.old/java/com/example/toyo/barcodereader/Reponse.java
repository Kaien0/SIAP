package com.example.toyo.barcodereader;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.annotation.Nullable;
import android.support.annotation.UiThread;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;

import com.example.toyo.barcodereader.com.testjdbc.bdd.ConstructeurReponse;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.concurrent.ExecutionException;

/**
 * Created by bashark on 11/09/2016.
 */
public class Reponse {
    private String nom, texte;
    private String id;
    Context ctx;

    public Reponse(Context ctx, int id_rep) {
        this.ctx = ctx;
        final ConstructeurReponse repTask = new ConstructeurReponse(ctx);

        String geet = null;
        String questt = null;
        String[] TAB_reponse = null;

        try {
            if((geet = repTask.execute("4").get()) != null){
                Log.d("TEST-----------TEST",geet);
                TAB_reponse = geet.split("<br/>");
                for(int i = 0; i<TAB_reponse.length; i++){
                    Log.d("TABLEAU", TAB_reponse[i]);
                }
                //Log.d("AAAAAAAAAAAAAA", repTask.getStatus().toString());

            }
           //id = Integer.valueOf(TAB_reponse[0]);
            id = TAB_reponse[0];
            nom = TAB_reponse[1];
            texte = TAB_reponse[2];

        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }
        Log.d("CCCCCC",repTask.getStatus().toString());


//        try {
//            Log.d("TEST------------TEST","chargement du driver...");
//            Class.forName("com.mysql.jdbc.Driver");
//            Log.d("TEST------------TEST","création de la connexion...");
//            Connection conn = DriverManager.getConnection("jdbc:mysql://db646793978.db.1and1.com:3306/db646793978","user=db646793978","password=Alegui77&");
//            Log.d("TEST------------TEST","création du statement...");
//            Statement st = conn.createStatement();
//            Log.d("TEST------------TEST","création du resultSet...");
//            ResultSet rs = st.executeQuery("SELECT id_reponse, nom_reponse, texte_reponse FROM reponse WHERE id_reponse = 2");
//            Log.d("TEST------------TEST","initialisation de la chaine de récéption...");
//            String str = "";// = rs.toString();
//            Log.d("TEST------------TEST","début de la boucle de lecture...");
//            while (rs.next()){
//                Log.d("TEST------------TEST","          boucle <-");
//                str = str + rs.toString();
//            }
//            Log.d("TEST------------TEST",str);
//        } catch (SQLException e) {
//            e.printStackTrace();
//        } catch (ClassNotFoundException e) {
//            e.printStackTrace();
//        }

//        BackgroundTask bt = new BackgroundTask(ctx);
//        bt.execute("constructeurReponse", "2");

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


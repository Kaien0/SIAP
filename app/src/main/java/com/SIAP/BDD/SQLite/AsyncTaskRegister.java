package com.SIAP.BDD.SQLite;

import android.content.Context;
import android.os.AsyncTask;

import com.SIAP.Classes.Agent;

/**
 * Created by Kaien on 06/10/2016.
 */
public class AsyncTaskRegister  extends AsyncTask<String,Void,String> {

    Context ctx;
    public AsyncTaskRegister(Context ctx){this.ctx = ctx;};

    @Override
    protected String doInBackground(String... params) {

        int res;
        GestionBD db = new GestionBD(ctx);
        db.open();
        final Agent agent = new Agent(params[0],params[1]);
        db.ajouterAgent(agent);
        db.close();
        return null;
    }



}

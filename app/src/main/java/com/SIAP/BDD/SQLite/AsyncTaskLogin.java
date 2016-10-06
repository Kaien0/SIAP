package com.SIAP.BDD.SQLite;

import android.content.Context;
import android.os.AsyncTask;

/**
 * Created by Kaien on 06/10/2016.
 */
public class AsyncTaskLogin extends AsyncTask<String,Void,String> {

    Context ctx;
    public AsyncTaskLogin(Context ctx){this.ctx = ctx;};

    @Override
    protected String doInBackground(String... params) {

        int res;
        GestionBD db = new GestionBD(ctx);
        db.open();
        if(db.login(params[0], params[1]) == 1){
            db.close();
            return "1";
        }
        db.close();
        return "0";
    }



}

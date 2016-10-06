package com.example.toyo.barcodereader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import com.SIAP.Classes.Reponse;


/**
 * Created by bashark on 10/09/2016.
 */
public class questionActivity extends Activity {
    // visibility
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.question);
        TextView tv = (TextView) findViewById(R.id.LIB_question);

        Reponse rep = new Reponse(this, 2);
        Log.d("REPONSE", String.valueOf(rep.getId()));
        Log.d("REPONSE", String.valueOf(rep.getTexte()));
        Log.d("REPONSE", String.valueOf(rep.getNom()));

    }

}

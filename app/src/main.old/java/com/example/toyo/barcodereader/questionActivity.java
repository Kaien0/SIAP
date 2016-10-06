package com.example.toyo.barcodereader;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.BufferedWriter;
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
import java.net.URLEncoder;


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

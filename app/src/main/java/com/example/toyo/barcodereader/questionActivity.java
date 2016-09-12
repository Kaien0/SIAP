package com.example.toyo.barcodereader;

import android.app.Activity;
import android.content.Intent;
import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
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

        final Parc parc = new Parc(this, "2");
//        Log.d("FORMULAIRE",form.getId());
//        Log.d("FORMULAIRE", form.getNom());

        Boolean next = false;

        for (int i = 0; i < parc.getJeu(0).getFormulaire().getLST_question().size(); i++){
            genererQuestion(parc.getJeu(0).getFormulaire());
        }





    }

    public Void genererQuestion(final Formulaire formulaire){
        setContentView(R.layout.question);
        final Formulaire form = formulaire;
        if(form.getIndice() < form.getLST_question().size()){
            Boolean next = false;
            TextView tv = (TextView) findViewById(R.id.LIB_question);
            tv.setText(form.getQuestion(form.getIndice()).getTexte());

            for(int j = 0; j < form.getQuestion(form.getIndice()).getLST_reponse().size(); j++){
                switch (j){
                    case 0:Button repA = (Button) findViewById(R.id.BTN_reponse_A);
                        repA.setText(form.getQuestion(form.getIndice()).getReponse(j).getTexte());
                        repA.setVisibility(View.VISIBLE);
                        repA.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                form.setIndice(form.getIndice() + 1);
                                genererQuestion(form);
                            }
                        });
                        break;
                    case 1:Button repB = (Button) findViewById(R.id.BTN_reponse_B);
                        repB.setText(form.getQuestion(form.getIndice()).getReponse(j).getTexte());
                        repB.setVisibility(View.VISIBLE);
                        repB.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                form.setIndice(form.getIndice() + 1);
                                genererQuestion(form);
                            }
                        });
                        break;
                    case 2:Button repC = (Button) findViewById(R.id.BTN_reponse_C);
                        repC.setText(form.getQuestion(form.getIndice()).getReponse(j).getTexte());
                        repC.setVisibility(View.VISIBLE);
                        repC.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                form.setIndice(form.getIndice() + 1);
                                genererQuestion(form);
                            }
                        });
                        break;
                    case 3:Button repD = (Button) findViewById(R.id.BTN_reponse_D);
                        repD.setText(form.getQuestion(form.getIndice()).getReponse(j).getTexte());
                        repD.setVisibility(View.VISIBLE);
                        repD.setOnClickListener(new View.OnClickListener() {
                            @Override
                            public void onClick(View view) {
                                form.setIndice(form.getIndice() + 1);
                                genererQuestion(form);
                            }
                        });
                        break;
                    default:
                        break;
                }

            }


        }else {
            Intent in = new Intent(questionActivity.this, AccueilActivity.class);
            startActivity(in);
        }

        return null;
    }

}

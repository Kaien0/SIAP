package com.SIAP.Activity;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.SIAP.BDD.SQLite.AsyncTaskLogin;
import com.example.toyo.barcodereader.R;

import java.lang.String;
import java.util.concurrent.ExecutionException;

public class LoginActivity extends Activity {

    final String EXTRA_ID = "user_id";
    final String EXTRA_MDP = "user_mdp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final TextView ID = (TextView)findViewById(R.id.eTxtID);
        final TextView PW = (TextView)findViewById(R.id.eTxtMdp);
        final String sID = ID.getText().toString();
        final String sPW = PW.getText().toString();
        //final GestionBD db = new GestionBD(this);
        //db.read();
        Intent intent = getIntent();
        if(intent != null){
            ID.setText(intent.getStringExtra(EXTRA_ID));
            PW.setText(intent.getStringExtra(EXTRA_MDP));
        }

        Button BtnConnexion = (Button)findViewById(R.id.BtnConnexion);
        BtnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override //Bouton Connexion
            public void onClick(View v) {
                if(ID.getText().toString().equals("") || PW.getText().toString().equals("")){
                   Toast.makeText(LoginActivity.this,"L'identifiant et le mot de passe sont obligatoires",Toast.LENGTH_SHORT).show();

                }
                else {/*
                   String method = "login";
                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
                    backgroundTask.execute(method,ID.getText().toString(), PW.getText().toString());
                    try {
                        String auth = backgroundTask.get().toString();
                        if(auth.equals("  LoginOK!")){
                            Intent i = new Intent(LoginActivity.this, AccueilActivity.class);
                            startActivity(i);
                        }
                        else{
                           Toast.makeText(LoginActivity.this, "Identifiant incconu", Toast.LENGTH_LONG).show();
                        }
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }*/

/*            ------------------------Log via SQLite, pense à remettre la creation de la db et l'ouverture db.read()          */
//                    if(db.login(ID.getText().toString(), PW.getText().toString()) ==1){
//                        Intent i = new Intent(LoginActivity.this, AccueilActivity.class);
//                        db.close();
//                        startActivity(i);
//                    }
                    AsyncTaskLogin A = new AsyncTaskLogin(LoginActivity.this);
                    try {
                        String res = A.execute(ID.getText().toString(), PW.getText().toString()).get();
                        if(res.equals("1")){
                            Intent i = new Intent(LoginActivity.this, AccueilActivity.class);
                            startActivity(i);
                        }
                        else{
                            Toast.makeText(LoginActivity.this, "Identifiant incconu", Toast.LENGTH_LONG).show();
                        }

                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } catch (ExecutionException e) {
                        e.printStackTrace();
                    }





                }
            }
        });

        Button BtnCreation = (Button)findViewById(R.id.BtnCreationCompte);
        BtnCreation.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(LoginActivity.this, CreationCompteActivity.class);
                startActivity(i);
            }
        });

    }
}

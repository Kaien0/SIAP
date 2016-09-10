package com.example.toyo.barcodereader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

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
                else {
                    String method = "login";
                    BackgroundTask backgroundTask = new BackgroundTask(LoginActivity.this);
                    backgroundTask.execute(method,ID.getText().toString(), PW.getText().toString());

                    Intent i = new Intent(LoginActivity.this, AccueilActivity.class);
                    startActivity(i);
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

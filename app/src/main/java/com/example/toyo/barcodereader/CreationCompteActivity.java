package com.example.toyo.barcodereader;


import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class CreationCompteActivity extends Activity {
 //VOIR le xml pour enlever le retour chariot
    //android:imeOptions="ActionNext"
    final String EXTRA_ID = "user_id";
    final String EXTRA_MDP = "user_mdp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationcompte);

        final EditText compte = (EditText)findViewById(R.id.eTxtCompte);
        final EditText mdp1 = (EditText)findViewById(R.id.eTxTMdp1);
        final EditText mdp2 = (EditText)findViewById(R.id.eTxTMdp2);


        Button annuler = (Button)findViewById(R.id.BtnAnnuler);
        annuler.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(CreationCompteActivity.this, LoginActivity.class);
                startActivity(i);
            }
        });

        Button inscrire = (Button)findViewById(R.id.BtnInscrire);
        inscrire.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(compte.getText().toString().isEmpty() || mdp1.getText().toString().isEmpty() || mdp2.getText().toString().isEmpty()){
                    Toast.makeText(CreationCompteActivity.this, "Veuillez remplir tous les champs", Toast.LENGTH_LONG).show();
                }
                else if(!mdp1.getText().toString().equals(mdp2.getText().toString())){ //!string.equal() = !=
                    Toast.makeText(CreationCompteActivity.this, "Les mots de passes ne sont pas identiques", Toast.LENGTH_LONG).show();
                }
                else{
                    Intent i = new Intent(CreationCompteActivity.this, LoginActivity.class);
                    i.putExtra(EXTRA_ID, compte.getText().toString());
                    i.putExtra(EXTRA_MDP, mdp1.getText().toString());
                    startActivity(i);

                }



            }
        });
    }
}

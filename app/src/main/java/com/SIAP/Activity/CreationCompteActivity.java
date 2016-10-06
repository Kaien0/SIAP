package com.SIAP.Activity;


import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.SIAP.BDD.SQLite.GestionBD;
import com.SIAP.BDD.SQLite.AsyncTaskRegister;
import com.example.toyo.barcodereader.R;

public class CreationCompteActivity extends Activity {
    GestionBD db;
    final String EXTRA_ID = "user_id";
    final String EXTRA_MDP = "user_mdp";

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.creationcompte);
        final Context ctx = this;
        final EditText compte = (EditText)findViewById(R.id.eTxtCompte);
        final EditText mdp1 = (EditText)findViewById(R.id.eTxTMdp1);
        final EditText mdp2 = (EditText)findViewById(R.id.eTxTMdp2);
        //db = new GestionBD(this);
        //db.open();


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
                    //Essaie de set un Utilisateur et ajout Bdd
                    /*try{
                        String c = compte.getText().toString();
                        String m = mdp1.getText().toString();
                        String method = "register";
                        BackgroundTask backgroundTask = new BackgroundTask(CreationCompteActivity.this);
                        backgroundTask.execute(method, c, m);
                        finish();
                        user.setNom(compte.getText().toString());
                        user.setMdp(mdp1.getText().toString());
                    }
                    catch (Exception e){
                        e.printStackTrace();
                    }*/
                    //Création de l'agent et ajout dans la BDD locale
                    //final Agent agent = new Agent(compte.getText().toString(),mdp1.getText().toString());
                    //db.ajouterAgent(agent);
                    //db.close();
                    //Retour à l'activité Login avec passage de données
                    AsyncTaskRegister A = new AsyncTaskRegister(CreationCompteActivity.this);
                    A.execute(compte.getText().toString(), mdp1.getText().toString());
                    Intent i = new Intent(CreationCompteActivity.this, LoginActivity.class);
                    i.putExtra(EXTRA_ID, compte.getText().toString());
                    i.putExtra(EXTRA_MDP, mdp1.getText().toString());
                    startActivity(i);
                }
            }
        });
    }
}

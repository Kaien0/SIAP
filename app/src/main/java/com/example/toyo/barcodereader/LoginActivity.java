package com.example.toyo.barcodereader;


import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import java.lang.String;

public class LoginActivity extends Activity {


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login);

        final TextView ID = (TextView)findViewById(R.id.eTxtID);
        final TextView PW = (TextView)findViewById(R.id.eTxtMdp);
        final String sID = ID.getText().toString();
        final String sPW = PW.getText().toString();

        Button BtnConnexion = (Button)findViewById(R.id.BtnConnexion);
        BtnConnexion.setOnClickListener(new View.OnClickListener() {
            @Override //Bouton Connexion
            public void onClick(View v) {
                if(sID.equals("a") && sPW.equals("b")){
                   Toast.makeText(LoginActivity.this,"GG",Toast.LENGTH_SHORT).show();

                }
                else
                    Toast.makeText(LoginActivity.this,"BG",Toast.LENGTH_SHORT).show();
            }
        });

    }




}

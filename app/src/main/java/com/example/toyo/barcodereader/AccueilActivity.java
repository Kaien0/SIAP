package com.example.toyo.barcodereader;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AccueilActivity extends AppCompatActivity implements OnClickListener  {
    private Button scanBtn, loginBtn, formulaireBtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main); //activity_main

        formulaireBtn = (Button)findViewById(R.id.BtnFormulaireParc);
        formulaireBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, formulaireparcActivity.class);
                startActivity(intent);
            }
        });

        scanBtn = (Button)findViewById(R.id.scan_button);
        //Bouton changement de vue
        loginBtn = (Button)findViewById(R.id.btn_Login);
        loginBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(AccueilActivity.this, LoginActivity.class);
                startActivity(intent);
            }
        });
        formatTxt = (TextView)findViewById(R.id.scan_format);
        contentTxt = (TextView)findViewById(R.id.scan_content);

        scanBtn.setOnClickListener(this);
    }

    public void onClick(View v){
        if(v.getId()==R.id.scan_button){

            IntentIntegrator scanIntegrator = new IntentIntegrator(this);
            scanIntegrator.initiateScan();
        }
    }



    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("Format : " + scanFormat);
            contentTxt.setText("Code barre : " + scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }




}

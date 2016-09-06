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

public class MainActivity extends Activity {
    private Button scanBtn, loginBtn, formulaireBtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo); //activity_main

        final Thread ThBienvenue = new Thread() {
            public void run() {

                try {
                    sleep(5000);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    Intent i = new Intent(MainActivity.this, AccueilActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        ThBienvenue.start();

}}

package com.example.toyo.barcodereader;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import com.SIAP.Activity.AccueilActivity;

//Test
public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.logo);

        final Thread ThBienvenue = new Thread() {
            public void run() {

                try {
                    sleep(1000);

                } catch (InterruptedException e) {
                    e.printStackTrace();

                } finally {
                    Intent i = new Intent(MainActivity.this, AccueilActivity.class);//LoginActivity BYPASS LOGIN SCREEN---------------------
                    startActivity(i);
                    finish();
                }
            }
        };
        ThBienvenue.start();

}}

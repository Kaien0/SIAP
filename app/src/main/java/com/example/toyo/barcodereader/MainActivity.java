package com.example.toyo.barcodereader;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

public class MainActivity extends Activity {

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

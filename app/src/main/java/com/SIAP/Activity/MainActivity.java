package com.SIAP.Activity;

import android.app.Activity;
import android.os.Bundle;
import android.content.Intent;

import com.example.toyo.barcodereader.R;

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
                    Intent i = new Intent(MainActivity.this, LoginActivity.class);
                    startActivity(i);
                    finish();
                }
            }
        };
        ThBienvenue.start();

}}

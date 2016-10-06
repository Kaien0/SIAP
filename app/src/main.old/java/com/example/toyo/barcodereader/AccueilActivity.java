package com.example.toyo.barcodereader;

import android.app.Activity;
import android.os.Bundle;

import com.SIAP.Activity.LoginActivity;
import com.SIAP.Activity.formulaireparcActivity;
import com.SIAP.Activity.questionActivity;
import com.SIAP.BDD.Distante.BackgroundTask;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


public class AccueilActivity extends Activity implements OnClickListener  {
    private Button scanBtn, loginBtn, formulaireBtn, questionsBtn;
    private TextView formatTxt, contentTxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Recup intent recupQuestion
        try{
            Intent BackgroundTaskRecupQuestion = getIntent();
            String[] EXTRA_TabQuest = BackgroundTaskRecupQuestion.getStringArrayExtra("EXTRA_TabQuest");
            for( int p = 0; p < EXTRA_TabQuest.length; p++){
                Log.d("AAAAAAA", EXTRA_TabQuest[p]);
            }
        } catch (NullPointerException e){
            e.printStackTrace();
        }

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

        questionsBtn = (Button) findViewById(R.id.Btn_questions);
        questionsBtn.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(AccueilActivity.this, questionActivity.class);
                startActivity(i);
            }
        });
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
            String method = "checkParc";
            BackgroundTask backgroundTask = new BackgroundTask(AccueilActivity.this);
            backgroundTask.execute(method, scanContent);
            //Questions
            BackgroundTask recupQuestions = new BackgroundTask(AccueilActivity.this);
            recupQuestions.execute("recupQuestions", scanContent);
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }
    }




}

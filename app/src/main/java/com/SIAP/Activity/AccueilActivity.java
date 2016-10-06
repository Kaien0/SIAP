package com.SIAP.Activity;

import android.app.Activity;
import android.os.Bundle;

import com.SIAP.Classes.Question;

import com.SIAP.R;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;
import android.content.Intent;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

//
public class AccueilActivity extends Activity implements OnClickListener  {
    private Button scanBtn, loginBtn, formulaireBtn, questionsBtn;
    private TextView formatTxt, contentTxt;
    String[] EXTRA_TabQuest;
    String[] EXTRA_TabConstructQuestion ;
    Question quest;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

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
                Intent i = new Intent(AccueilActivity.this, questionActivity.class); //Probleme car Question.constructeurQuestion commenté
                startActivity(i);
            }
        });
    }

    @Override
    public void onClick(View v) {

    }


//    public void onClick(View v){
//        if(v.getId()==R.id.scan_button){
//            Question question = new Question(this, String.valueOf(8));
//            Log.d("QUESTION", question.getId());
//            Log.d("QUESTION", question.getNom());
//            Log.d("QUESTION", question.getTexte());
//            for(int i = 0; i < question.getLST_reponse().size(); i++){
//                Log.d("REPONSE", question.getReponse(i).getTexte());
//            }



//            ArrayList<Reponse> TabRep = new ArrayList(question.getLST_reponse());
//            for(int i = 0; i<TabRep.size();i++){
//                Log.d("STRINGREPOOONSEQUESTION" , String.valueOf(TabRep.get(i)));
//            }



            // IntentIntegrator scanIntegrator = new IntentIntegrator(this);
           //a scanIntegrator.initiateScan();
//        }
//    }

    public void onActivityResult(int requestCode, int resultCode, Intent intent) {
        IntentResult scanningResult = IntentIntegrator.parseActivityResult(requestCode, resultCode, intent);
        if (scanningResult != null) {
            String scanContent = scanningResult.getContents();
            String scanFormat = scanningResult.getFormatName();
            formatTxt.setText("Format : " + scanFormat);
            contentTxt.setText("Code barre : " + scanContent);

//                Question question = new Question(this, String.valueOf(6));
//                Log.d("QUESTION", String.valueOf(question.getId()));
//                Log.d("QUESTION", String.valueOf(question.getTexte()));
//                Log.d("QUESTION", String.valueOf(question.getNom()));
            //Log.d("REPONSE", );  FAIRE GETTER LIST REPONSE
        }
        else{
            Toast toast = Toast.makeText(getApplicationContext(),
                    "No scan data received!", Toast.LENGTH_SHORT);
            toast.show();
        }

    }

}

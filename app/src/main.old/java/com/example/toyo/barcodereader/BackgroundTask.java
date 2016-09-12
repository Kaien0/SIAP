package com.example.toyo.barcodereader;
import android.app.AlertDialog;
import android.app.DownloadManager;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.AsyncTask;
import android.util.Log;
import android.widget.Toast;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.ProtocolException;
import java.net.URL;
import java.net.URLConnection;
import java.net.URLEncoder;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Properties;


public class BackgroundTask extends AsyncTask<String,Void,String> {

    AlertDialog alertDialog;
    Context ctx;
    BackgroundTask(Context ctx)
    {
        this.ctx =ctx;
    }
    @Override
    protected void onPreExecute() {
        //alertDialog = new AlertDialog.Builder(ctx).create();
        //alertDialog.setTitle("Login Information....");
    }
    @Override
    protected String doInBackground(String... params) {
        String reg_url = "http://Kaien.fr/creationCompte.php";
        String login_url = "http://Kaien.fr/login.php";  // A changer
        String parc_url = "http://Kaien.fr/checkParc.php";
        String questions_url = "http://Kaien.fr/recupQuestion.php";
        String method = params[0];

        if (method.equals("register")) {
            String user_name = params[1];
            String user_pass = params[2];
            try {
                URL url = new URL(reg_url);
                URLConnection conn = url.openConnection();
//                conn.setRequestMethod("POST");
                conn.setDoOutput(true);

                //conn.setDoInput(true);
                OutputStreamWriter OS = new OutputStreamWriter(conn.getOutputStream());

                String data = URLEncoder.encode("user_name", "UTF-8") + "=" + URLEncoder.encode(user_name, "UTF-8") + "&" +
                        URLEncoder.encode("user_pass", "UTF-8") + "=" + URLEncoder.encode(user_pass, "UTF-8");
                OS.write(data);
                OS.flush();
                OS.close();
                InputStreamReader IS = new InputStreamReader(conn.getInputStream());
                IS.close();
                //conn.connect();

                return "Registration Success...";

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        else if(method.equals("login"))
        {
            String login_name = params[1];
            String login_pass = params[2];
            try {
                URL url = new URL(login_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                String data = URLEncoder.encode("login_name","UTF-8")+"="+URLEncoder.encode(login_name,"UTF-8")+"&"+
                        URLEncoder.encode("login_pass","UTF-8")+"="+URLEncoder.encode(login_pass,"UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine())!=null)
                {
                    response+= line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


        //*********CheckParc***********//
        else if (method.equals("checkParc")) {
            String idParc = params[1];
            try {
                URL url = new URL(parc_url);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("idParc", "UTF-8") + "=" + URLEncoder.encode(idParc, "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8"));
                String response = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    response += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return response;

            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
                /********* RecupQuestions*****/
                else if (method.equals("recupQuestions"))
                {
                    String idParc = params[1];
                    try {
                        URL url = new URL(questions_url);
                        HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection();
                        httpURLConnection.setRequestMethod("POST");
                        httpURLConnection.setDoOutput(true);
                        httpURLConnection.setDoInput(true);
                        OutputStream outputStream = httpURLConnection.getOutputStream();
                        BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream,"UTF-8"));
                        String data = URLEncoder.encode("idParc","UTF-8")+"="+URLEncoder.encode(idParc,"UTF-8");
                        bufferedWriter.write(data);
                        bufferedWriter.flush();
                        bufferedWriter.close();
                        outputStream.close();
                        InputStream inputStream = httpURLConnection.getInputStream();
                        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream,"UTF-8")); //iso-8859-1
                        String response = "";
                        String line = "";
                        while ((line = bufferedReader.readLine())!=null)
                        {
                            response+= line;
                        }
                        bufferedReader.close();
                        inputStream.close();
                        httpURLConnection.disconnect();

                        return response;


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else if(method.equals("constructeurReponse")){
            String url_rep = "http://Kaien.fr/constructeurReponse.php";
            String id = params[1];
            try {
                URL url = new URL(url_rep);
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                httpURLConnection.setRequestMethod("POST");
                httpURLConnection.setDoOutput(true);
                httpURLConnection.setDoInput(true);
                OutputStream outputStream = httpURLConnection.getOutputStream();
                BufferedWriter bufferedWriter = new BufferedWriter(new OutputStreamWriter(outputStream, "UTF-8"));
                String data = URLEncoder.encode("id", "UTF-8") + "=" + URLEncoder.encode(String.valueOf(id), "UTF-8");
                bufferedWriter.write(data);
                bufferedWriter.flush();
                bufferedWriter.close();
                outputStream.close();
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream, "UTF-8")); //iso-8859-1
                String reponse = "";
                String line = "";
                while ((line = bufferedReader.readLine()) != null) {
                    reponse += line;
                }
                bufferedReader.close();
                inputStream.close();
                httpURLConnection.disconnect();

                return reponse;


            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            } catch (ProtocolException e) {
                e.printStackTrace();
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        return null; //Return si on ne passe dans aucun if

    }
    @Override
    protected void onProgressUpdate(Void... values) {
        super.onProgressUpdate(values);
    }
    @Override
    protected void onPostExecute(String result) {
        if(result.equals("Registration Success..."))
        {
            Toast.makeText(ctx, "Enregistrement reussi", Toast.LENGTH_LONG).show();
        }
        else if(result.equals("  LoginOK!")){
//           alertDialog.setMessage("ON EST CONNECTEEE");
            Toast.makeText(ctx, "Authentification reussie", Toast.LENGTH_SHORT).show();
        }
        /*else if (result.equals("  LeParcExiste")){
            Toast.makeText(ctx, "Le parc existe", Toast.LENGTH_LONG).show();

        }
        else if (result.equals("  LeParcNexistePas")){
            Toast.makeText(ctx, "Le parc n'existe pas", Toast.LENGTH_LONG).show();
        }*/
        else if(result.contains("Question")){
            String[] TabQuestions  = result.split("<br/>"); //Separe le result sur les retour lignes
            Intent i = new Intent(ctx, AccueilActivity.class);
            String[] EXTRA_TabQuest = new String[TabQuestions.length];
            EXTRA_TabQuest.clone();

            i.putExtra("EXTRA_TabQuest", TabQuestions);
            ctx.startActivity(i);

        }
        else
        {
            Toast.makeText(ctx, result, Toast.LENGTH_LONG).show();
            //alertDialog.setMessage(result);
            //alertDialog.show();
        }
    }

}


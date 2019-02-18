package com.example.dell.hack1;

import android.graphics.Color;
import android.net.Uri;
import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Display;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.Console;
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
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Scanner;

import javax.net.ssl.HttpsURLConnection;

public class result extends AppCompatActivity {
    Model m = new Model();
    TextView result1;

    StringBuilder st=new StringBuilder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_result);
        m = (Model) getIntent().getSerializableExtra("model");

        result1=findViewById(R.id.result);
        JSONObject postDataParams = new JSONObject();
       try {
           postDataParams.put("age", m.getQues0());
           postDataParams.put("gender", m.getQues1());
           postDataParams.put("self_emp", m.getQues2());
           postDataParams.put("mental_disorders", m.getQues3());
           postDataParams.put("mental_healthinPast", m.getQues4());
           postDataParams.put("work_from_home", m.getQues5());
           postDataParams.put("technology", m.getQues6());
           postDataParams.put("benefits", m.getQues7());
           postDataParams.put("know_benefits", m.getQues10());
           postDataParams.put("wellness", m.getQues8());

           postDataParams.put("mental_issues", m.getQues11());
           postDataParams.put("mental_health", m.getQues12());
       }
       catch (Exception e)
       {

       }
        try {
             st=getPostDataString(postDataParams);
        } catch (Exception e) {
            e.printStackTrace();
        }

        networktask nt=new networktask();
        Log.i("param1","https://mentalhealth200.herokuapp.com/testing"+st);


        nt.execute("https://mentalhealth200.herokuapp.com/testing"+st);


    }

    class networktask extends AsyncTask<String,Void,String>
    {

        @Override
        protected String doInBackground(String... strings) {
            String url=strings[0];
            try {
                URL url1=new URL(url);
                HttpURLConnection httpURLConnection= (HttpURLConnection) url1.openConnection();
                InputStream inputStream=httpURLConnection.getInputStream();
                Scanner scanner=new Scanner(inputStream);
                scanner.useDelimiter("\\A");
                if(scanner.hasNext())
                {
                    String s=scanner.next();
                    return s;
                }
            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return "failed to load";
        }

        @Override
        protected void onPostExecute(String s) {
            super.onPostExecute(s);


            String ss=parsejson(s);

            Log.i("param1",ss);
            if(ss.equals("0"))
            {

                result1.setText("MILD DEPRESSION");
                result1.setBackgroundColor(Color.YELLOW);

            }
            else if(ss.equals("1"))
            {
                result1.setText("NO DEPRESSION");
                result1.setBackgroundColor(Color.GREEN);
            }
            else if(ss.equals("2"))
            {
                result1.setText("DEPRESSED");
                result1.setBackgroundColor(Color.RED);
            }
        }
    }

    String parsejson(String s)
    {
        Log.i("param",s);
     String ss="";
        try {
            JSONObject root=new JSONObject(s);

            ss = root.getString("result");


        } catch (JSONException e) {
            e.printStackTrace();
        }

        //parseing json
        return ss;
    }
    public StringBuilder getPostDataString(JSONObject params) throws Exception {

        StringBuilder result = new StringBuilder("?");
        boolean first = true;

        Iterator<String> itr = params.keys();

        while (itr.hasNext()) {

            String key = itr.next();
            Object value = params.get(key);

            if (first)
                first = false;
            else
                result.append("&");

            result.append(URLEncoder.encode(key, "UTF-8"));
            result.append("=");
            result.append(URLEncoder.encode(value.toString(), "UTF-8"));

        }

        Log.i("param", result.toString());
        return result;
    }

}





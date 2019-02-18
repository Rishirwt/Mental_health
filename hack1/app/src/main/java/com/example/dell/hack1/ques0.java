package com.example.dell.hack1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class ques0 extends AppCompatActivity {

    Model m=new Model();
    EditText e1;
    int age=0;
    Button submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques0);
        submit=findViewById(R.id.submit);
       e1=findViewById(R.id.t1);
        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(e1.getText().toString().matches("")) {
                    Toast.makeText(ques0.this,"ENTER YOUR AGE",Toast.LENGTH_SHORT).show();
                    }
                else
                {
                    age = Integer.parseInt(e1.getText().toString());
                    m.setQues0(age);

                    Intent i=new Intent(ques0.this,ques1.class);
                    i.putExtra("model",m);
                    startActivity(i);
                    finish();
                }



            }
        });


    }
}

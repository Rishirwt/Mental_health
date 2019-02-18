package com.example.dell.hack1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ques2 extends AppCompatActivity {

    int option=0;
    Model m=new Model();
    Button b1,b2,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques2);
        submit=findViewById(R.id.submit);
        m = (Model) getIntent().getSerializableExtra("model");
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);


        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option=1;
                b1.setBackground(getResources().getDrawable(R.drawable.button_shape2));
                b2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                               }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(ques2.this,ques3.class);

                if(option==1)
                    m.setQues2(1);
                else if(option==2)
                    m.setQues2(0);
                i.putExtra("model",m);
                startActivity(i);
                finish();
            }
        });
        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option=2;
                b2.setBackground(getResources().getDrawable(R.drawable.button_shape2));
                b1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                               }
        });


    }
}

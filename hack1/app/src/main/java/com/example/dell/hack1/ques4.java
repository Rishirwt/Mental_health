package com.example.dell.hack1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ques4 extends AppCompatActivity {


    Model m=new Model();

    int option=0;
    Button b1,b2,submit;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques4);
        submit=findViewById(R.id.submit);
        b1=findViewById(R.id.b1);
        b2=findViewById(R.id.b2);

        m = (Model) getIntent().getSerializableExtra("model");

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
                Intent i=new Intent(ques4.this,ques5.class);
                if(option==1)
                    m.setQues4(1);
                else if(option==2)
                    m.setQues4(0);

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

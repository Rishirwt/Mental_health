package com.example.dell.hack1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class ques11 extends AppCompatActivity {
    int option=0;
    Model m=new Model();
    Button b1,b2,b3,submit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ques11);
        submit=findViewById(R.id.submit);
        b1=findViewById(R.id.b1);
        m = (Model) getIntent().getSerializableExtra("model");
        b2=findViewById(R.id.b2);
        b3=findViewById(R.id.b3);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option=1;
                b1.setBackground(getResources().getDrawable(R.drawable.button_shape2));
                b2.setBackground(getResources().getDrawable(R.drawable.button_shape));
                b3.setBackground(getResources().getDrawable(R.drawable.button_shape));                    }
        });

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent i=new Intent(ques11.this,ques12.class);
                if(option==1)
                    m.setQues11(2);
                else if(option==2)
                    m.setQues11(1);
                else
                    m.setQues11(0);

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
                b3.setBackground(getResources().getDrawable(R.drawable.button_shape));                    }
        });

        b3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                option=3;
                b3.setBackground(getResources().getDrawable(R.drawable.button_shape2));
                b1.setBackground(getResources().getDrawable(R.drawable.button_shape));
                b2.setBackground(getResources().getDrawable(R.drawable.button_shape));                    }
        });
    }
}

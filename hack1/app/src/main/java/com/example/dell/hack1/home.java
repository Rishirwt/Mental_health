package com.example.dell.hack1;

import android.content.ActivityNotFoundException;
import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

import static java.security.AccessController.getContext;

public class home extends AppCompatActivity {
ImageView title;
    ListView lv;
    Button b1;
    ArrayList<cards> tr=cards.getrandom();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        lv =(ListView) findViewById(R.id.lv);
        b1 = findViewById(R.id.button2);

        TeacherAdapter ta = new TeacherAdapter();
        lv.setAdapter(ta);



        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(home.this,homepage.class);
                startActivity(i);
                finish();
            }
        });

        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                Log.i("lol","ss");
                if(position==1)
                {
                    Log.i("lol","ssss");
                    try {
                        Intent myIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.verywellmind.com/a-list-of-psychological-disorders-2794776"));
                        startActivity(myIntent);
                    } catch (ActivityNotFoundException e) {
                        Toast.makeText(home.this, "No application can handle this request."
                                + " Please install a webbrowser",  Toast.LENGTH_LONG).show();
                        e.printStackTrace();
                    }
                }
            }
        });
    }
    class TeacherAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return tr.size();
        }

        @Override
        public cards getItem(int position) {
            return tr.get(position);
        }

        @Override
        public long getItemId(int position) {
            return 0;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {

            View look=getLayoutInflater().inflate(R.layout.card,parent,false);
            ImageView im=look.findViewById(R.id.imageView2);
            TextView desc=look.findViewById(R.id.desc);
            Picasso.get().load(getItem(position).getUrl()).resize(390,200).into(im);

            desc.setText(getItem(position).getContent());
            return look;
        }
    }
}

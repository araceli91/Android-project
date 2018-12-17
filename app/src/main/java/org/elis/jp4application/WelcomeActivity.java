package org.elis.jp4application;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.util.ArrayList;

import static org.elis.jp4application.MainActivity.WELCOME;

    public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

        TextView welcomeTW;
        String mail;
        String openMail;
        Button plus, minus;
        RecyclerView recyclerView;
        LinearLayoutManager layoutManager;
        FoodListAdapter adapter;

        @Override
        protected void onCreate(@Nullable Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_welcome);

            welcomeTW = findViewById(R.id.welcome_tv);

            welcomeTW.setOnClickListener(this);
            //plus.setOnClickListener(this);
            //minus.setOnClickListener(this);

            recyclerView = findViewById(R.id.food_rv);

            layoutManager = new LinearLayoutManager(this);
            ArrayList<Food> foodList = new ArrayList<>();


            adapter = new FoodListAdapter(this, foodList);
            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(layoutManager);


            if (getIntent().getStringExtra(WELCOME) != null) {
                mail = getIntent().getStringExtra(WELCOME);
                welcomeTW.setText(getString(R.string.welcome) + " " + mail);
            } else {
                openMail = getIntent().getData().toString();//.substring(7);
                Log.e("ARAAPP", openMail);
                openMail = Uri.decode(openMail);
                Log.e("ARAAPP", openMail);
                welcomeTW.setText(openMail);
            }

        }

        @Override
        public void onClick(View view) {
            if (view.getId() == R.id.welcome_tv) {
                Intent i = new Intent(Intent.ACTION_SENDTO, Uri.fromParts(
                        "mailto", mail, null));
                startActivity(Intent.createChooser(i, "Choose an Email client :"));

            }

            welcomeTW = findViewById(R.id.welcome_tv);
            welcomeTW = findViewById(R.id.email_et);


            //Intent intent = getIntent();

       /* if(intent != null){
            if(intent.getStringExtra(MainActivity.WELCOME) != null)
                emailTv.setText(intent.getStringExtra(MainActivity.WELCOME));

            else if(intent.getAction()!= null && intent.getAction() == Intent.ACTION_SENDTO)
                emailTv.setText(intent.getData());
        }

        emailTv.setText(mail);
        emailTv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Uri uri = Uri.parse("mailto:" + mail);
                Intent sendMailIntent = new Intent(Intent.ACTION_SENDTO,uri);
                startActivity(sendMailIntent);
            }
        });*/
        }
        private ArrayList <Food> getProducts(){
            ArrayList<Food> foodList = new ArrayList<>();

            foodList.add(new Food("Bread", 2.0, 0));
            foodList.add(new Food("Orange", 3.0, 0));
            foodList.add(new Food("Peanuts Butter", 1.5, 0));
            foodList.add(new Food("Butter", 2.0, 0));
            return foodList;


        }
    }


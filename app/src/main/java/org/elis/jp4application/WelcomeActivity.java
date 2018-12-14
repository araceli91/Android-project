package org.elis.jp4application;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import static org.elis.jp4application.MainActivity.WELCOME;


public class WelcomeActivity extends AppCompatActivity implements View.OnClickListener {

    TextView welcomeTW;
    String mail;
    String openMail;
    Button plus, minus;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);

        welcomeTW.setOnClickListener(this);
        plus.setOnClickListener(this);
        minus.setOnClickListener(this);



        if (getIntent().getStringExtra(WELCOME)!= null) {
            mail = getIntent().getStringExtra(WELCOME);
            welcomeTW.setText(getString(R.string.welcome) + " "+ mail);
        } else {
            openMail = getIntent().getData().toString();//.substring(7);
            Log.e("ARAAPP",openMail);
            openMail = Uri.decode(openMail);
            Log.e("ARAAPP",openMail);
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
    }

}


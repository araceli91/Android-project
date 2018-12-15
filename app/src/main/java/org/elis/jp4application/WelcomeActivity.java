package org.elis.jp4application;

<<<<<<< HEAD
import android.annotation.SuppressLint;
=======
>>>>>>> master
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
<<<<<<< HEAD
import android.util.Log;
import android.view.View;
import android.widget.Button;
=======
import android.view.View;
>>>>>>> master
import android.widget.TextView;

import static org.elis.jp4application.MainActivity.WELCOME;

<<<<<<< HEAD
=======
public class WelcomeActivity extends AppCompatActivity {

    TextView welcomeTW, emailTv;
>>>>>>> master

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



<<<<<<< HEAD
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
=======
        welcomeTW = findViewById(R.id.welcome_tv);
        emailTv = findViewById(R.id.email_tv);


        Intent intent = getIntent();

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


>>>>>>> master
    }

}


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

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

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
    TextView total;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        welcomeTW = findViewById(R.id.welcome_tv);

        welcomeTW.setOnClickListener(this);


        recyclerView = findViewById(R.id.food_row);

        layoutManager = new LinearLayoutManager(this);

        getProducts();



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

    ArrayList<Food> foodList = new ArrayList<>();



    private void getProducts () {
// Instantiate the RequestQueue.
        RequestQueue queue = Volley.newRequestQueue(this);
        String url = "https://5ba19290ee710f0014dd764c.mockapi.io/Food";

// Request a string response from the provided URL.
        StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        Log.d("Success", response);
                        try {
                            JSONObject reponseJSON = new JSONObject(response);
                            JSONArray jsonArray = reponseJSON.getJSONArray("foods");

                                for(int i = 0; i<jsonArray.length(); i++) {
                                    Food food = new Food(jsonArray.getJSONObject(i));
                                    foodList.add(food);
                                }

                            // Display the first 500 characters of the response string.
                        } catch (JSONException e) {
                            e.printStackTrace();
                        }
                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                Log.d("Error", error.getMessage());
            }
        });

// Add the request to the RequestQueue.

        queue.add(stringRequest);

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
        total = findViewById(R.id.total);

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

}
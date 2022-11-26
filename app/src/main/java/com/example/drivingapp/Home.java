package com.example.drivingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Home extends AppCompatActivity {

    Button lessons;
    Button details;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);



        lessons=(Button) findViewById(R.id.lessons);
        lessons.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openLessons();
            }
        });


        details=(Button) findViewById(R.id.details);
        details.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openDetails();
            }
        });


    }

    public void openLessons(){
        Intent intent=new Intent(Home.this,lesson1.class);
        startActivity(intent);

    }

    public void openDetails(){
        Intent intent=new Intent(Home.this,details.class);
        startActivity(intent);

    }


}
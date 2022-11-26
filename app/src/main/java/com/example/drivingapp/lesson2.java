package com.example.drivingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson2 extends AppCompatActivity {

    Button back;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson2);

        back=(Button) findViewById(R.id.back);
        next=(Button) findViewById(R.id.next) ;


        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goHome();
            }
        });


        next.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goNext();
            }
        });



    }

    public void goHome(){
        Intent intent=new Intent(lesson2.this,Home.class);
        startActivity(intent);
    }

    public void goNext(){
        Intent intent=new Intent(lesson2.this,lesson3.class);
        startActivity(intent);
    }



}
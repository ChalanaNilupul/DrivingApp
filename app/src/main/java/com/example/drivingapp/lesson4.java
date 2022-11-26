package com.example.drivingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;

import android.app.NotificationManager;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class lesson4 extends AppCompatActivity {

    Button back;
    Button next;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson4);

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
        Intent intent=new Intent(lesson4.this,Home.class);
        startActivity(intent);
    }

    public void goNext(){
        Intent intent=new Intent(lesson4.this,lesson5.class);
        startActivity(intent);
    }


}
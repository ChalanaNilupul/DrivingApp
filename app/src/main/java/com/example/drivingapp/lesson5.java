package com.example.drivingapp;

import androidx.appcompat.app.AppCompatActivity;

import android.app.NotificationChannel;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import android.app.Notification;
import android.app.NotificationManager;
import android.media.RingtoneManager;
import android.net.Uri;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

public class lesson5 extends AppCompatActivity {


    Button finish;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lesson5);

        checkVersion();



        finish=(Button) findViewById(R.id.finish);






        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NotificationCompat.Builder builder = new NotificationCompat.Builder(lesson5.this,"lemubitA")
                                .setSmallIcon(R.drawable.ic_launcher_foreground)
                                .setContentTitle("Driver Master")
                                .setContentText("You completed all the lessons")
                                .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(lesson5.this);
                notificationManager.notify(100,builder.build());

                goHome();
            }
        });

    }

    public void goHome(){
        Intent intent=new Intent(lesson5.this,Home.class);
        startActivity(intent);
    }

    public void checkVersion(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("lemubitA","my notification",NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }

}
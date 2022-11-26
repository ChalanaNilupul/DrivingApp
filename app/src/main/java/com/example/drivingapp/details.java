package com.example.drivingapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.NotificationCompat;
import androidx.core.app.NotificationManagerCompat;

import android.app.NotificationChannel;
import android.app.NotificationManager;
import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class details extends AppCompatActivity {
    Button finish;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);


        checkVersion();
        finish=(Button) findViewById(R.id.finish);


        finish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                NotificationCompat.Builder builder = new NotificationCompat.Builder(details.this,"lemubitA")
                        .setSmallIcon(R.drawable.ic_launcher_foreground)
                        .setContentTitle("Driver Master")
                        .setContentText("You checked all the points")
                        .setPriority(NotificationCompat.PRIORITY_DEFAULT);


                NotificationManagerCompat notificationManager = NotificationManagerCompat.from(details.this);
                notificationManager.notify(100,builder.build());

                goHome();
            }
        });


    }

    public void goHome(){
        Intent intent=new Intent(details.this,Home.class);
        startActivity(intent);
    }

    public void checkVersion(){
        if(Build.VERSION.SDK_INT >= Build.VERSION_CODES.O){
            NotificationChannel channel=new NotificationChannel("lemubitA","my notification", NotificationManager.IMPORTANCE_DEFAULT);
            NotificationManager manager=getSystemService(NotificationManager.class);
            manager.createNotificationChannel(channel);
        }
    }
}
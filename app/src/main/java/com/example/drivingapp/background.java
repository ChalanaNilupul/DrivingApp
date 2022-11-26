package com.example.drivingapp;

import android.os.AsyncTask;

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class background extends AsyncTask<String,Void,String> {

    @Override
    protected String doInBackground(String... voids) {

        String result="";
        String user=voids[0];
        String pass=voids[1];

        String constr = "http://localhost:8080/DriverMaster/login.php";

        try {
            URL url = new URL(constr);
            HttpURLConnection http =(HttpURLConnection) url.openConnection();
            http.setRequestMethod("POST");
            http.setDoInput(true);
            http.setDoOutput(true);



        }catch (MalformedURLException e) {
            result= e.getMessage();
        }catch(IOException e){
            result = e.getMessage();
        }


        return result;
    }
}

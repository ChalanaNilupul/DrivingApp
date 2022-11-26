package com.example.drivingapp;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;

public class signup extends AppCompatActivity {

    private TextView link;
    private EditText usr,password,cpass,mail;
    private Button signup;
    String emailAuth="[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+";
    ProgressDialog progressDialog;


    FirebaseAuth mAuth;
    FirebaseUser mUser;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



        setContentView(R.layout.activity_signup);

        link=findViewById(R.id.txtLink);
        mail=findViewById(R.id.txtEmail);
        usr = findViewById(R.id.txtUser);
        password = findViewById(R.id.txtPass);
        signup = findViewById(R.id.button);
        cpass=findViewById(R.id.txtConPass);
        progressDialog=new ProgressDialog(this);
        mAuth=FirebaseAuth.getInstance();
        mUser=mAuth.getCurrentUser();


        signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                performAuth();
            }
        });
        link.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                signin();
            }
        });

    }

    private void performAuth(){
        String user=usr.getText().toString();
        String pass=password.getText().toString();
        String conPass=cpass.getText().toString();
        String email=mail.getText().toString();
        if(!email.matches(emailAuth)){
            mail.setError("Enter Correct Email");
        }
        else if(pass.isEmpty() || pass.length()<8){
            password.setError("Enter Proper Password");
        }
        else if(!pass.equals(conPass)){
            cpass.setError("PasswordNot Match");
        }
        else{
            progressDialog.setMessage("Please wait while registration");
            progressDialog.setTitle("Registration");
            progressDialog.setCanceledOnTouchOutside(false);
            progressDialog.show();

            mAuth.createUserWithEmailAndPassword(email,pass).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if(task.isSuccessful())
                    {
                        progressDialog.dismiss();
                        openHome();
                        Toast.makeText(signup.this, "Registration Successfull", Toast.LENGTH_SHORT).show();
                    }else{
                        progressDialog.dismiss();
                        Toast.makeText(signup.this, ""+task.getException(), Toast.LENGTH_SHORT).show();
                    }
                }
            });


        }
    }

    public void openHome(){

        Intent intent=new Intent(signup.this,MainActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK|Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);

    }
    public void signin(){

        Intent intent=new Intent(signup.this,MainActivity.class);
        startActivity(intent);

    }


}
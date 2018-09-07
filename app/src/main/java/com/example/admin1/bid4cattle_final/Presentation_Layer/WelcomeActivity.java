package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.admin1.bid4cattle_final.R;
import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Controller;

public class WelcomeActivity extends AppCompatActivity {

    // Local variable declarations
    Button btn_signin;
    Button btn_signup;

    Controller controller;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_welcome);

        // Signup button
        this.btn_signup = (Button) findViewById(R.id.welcome_signup_button);
        this.btn_signup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });


        // Signin button
        this.btn_signin = (Button) findViewById(R.id.welcome_signin_button);
        this.btn_signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(WelcomeActivity.this, SigninActivity.class);
                startActivity(intent);
            }
        });

    }


}

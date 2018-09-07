package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Controller;
import com.example.admin1.bid4cattle_final.R;

public class SigninActivity extends AppCompatActivity {

    private EditText email, password;
    String userEmail, userPassword;
    Button loginButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        email = (EditText)findViewById(R.id.user_email);
        password = (EditText)findViewById(R.id.user_password);

        loginButton = (Button)findViewById(R.id.btn_login);
        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                Controller controller =new Controller();

                /*
                if(controller.check_Login(email.getText().toString(), password.getText().toString()))
                {
                    //user login details  = success
                    controller.popUp("Signed in successfully","Login successful ", SigninActivity.this);
                    Intent intent = new Intent(SigninActivity.this,MainActivity.class );
                    startActivity(intent);
                }*/
                Intent intent = new Intent(SigninActivity.this,MainActivity.class );
                startActivity(intent);
            }
        });

    }
}

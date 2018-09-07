package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Controller;
import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.User;
import com.example.admin1.bid4cattle_final.R;

public class SignupActivity extends AppCompatActivity {

    // Local variable declarations
    Button btn_proceed;
    EditText txt_name, txt_surname, txt_city, txt_email, txt_confirmEmail, txt_password, txt_confirmPassword;
    String name, surname, city, email, confirmEmail, password, confirmPassword;

    Controller controller;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        txt_name = (EditText)findViewById(R.id.edit_sign_up_name);
        txt_surname = (EditText)findViewById(R.id.edit_sign_up_last_name);
        txt_city = (EditText)findViewById(R.id.edit_city);
        txt_email = (EditText)findViewById(R.id.edit_sign_up_email);
        txt_confirmEmail = (EditText)findViewById(R.id.edit_sign_up_repeat_email);
        txt_password = (EditText)findViewById(R.id.edit_sign_up_password);
        txt_confirmPassword = (EditText)findViewById(R.id.edit_sign_up_repeat_password);

        // Retrieve values from EditText fields
        name = txt_name.getText().toString();
        surname = txt_surname.getText().toString();
        city = txt_city.getText().toString();
        email = txt_email.getText().toString();
        confirmEmail = txt_confirmEmail.getText().toString();
        password = txt_password.getText().toString();
        confirmPassword = txt_confirmPassword.getText().toString();

        controller = new Controller();


        btn_proceed = (Button)findViewById(R.id.btn_proceed);
        btn_proceed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                int userID = 0;
                //validation
                if(email.equals(confirmEmail))
                {
                    if (password.equals(confirmPassword))
                    {
                        //the user can be successully registered
                        userID = controller.getRandomInt();
                        controller.setUser(Integer.toString(userID),name, surname, city, email, password);
                        controller.save_data("Users.txt", controller.getUserDetails());

                        //successfully signed up
                        controller.popUp("Hello, "+ name +"!\n\nYou have registered sucessfully. Please click 'Continue' to proceed",
                                "Registration Sucess", SignupActivity.this);


                        //Proceed to the next activity
                        Intent intent = new Intent(SignupActivity.this, MainActivity.class);
                        intent.putExtra("userID",userID );
                        startActivity(intent);
                    }
                }

            }
        });
    }

}

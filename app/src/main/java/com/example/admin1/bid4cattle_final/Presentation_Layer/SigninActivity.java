package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Controller;
import com.example.admin1.bid4cattle_final.R;

public class SigninActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signin);

        Intent intent  = getIntent();
        Controller newController = (Controller)intent.getSerializableExtra("controller");

        System.out.println(newController);

    }
}

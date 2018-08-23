package com.example.admin1.bid4cattle_final;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.ListView;

public class BuyCattle extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        ImageView imageHolder = (ImageView)findViewById(R.id.viewImage);
        imageHolder.setImageResource(R.drawable.cow1);

    }


    }


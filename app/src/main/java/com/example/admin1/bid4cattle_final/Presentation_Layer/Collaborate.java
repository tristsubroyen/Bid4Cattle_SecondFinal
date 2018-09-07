package com.example.admin1.bid4cattle_final.Presentation_Layer;

import com.example.admin1.bid4cattle_final.R;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ImageView;

public class Collaborate extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_collab);

        ImageView imageHolder = (ImageView)findViewById(R.id.imageView2);
        imageHolder.setImageResource(R.drawable.cow1);

    }
}


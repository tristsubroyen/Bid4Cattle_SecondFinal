package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Button;
import android.content.Intent;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.admin1.bid4cattle_final.R;

import java.util.Random;

public class AuctionCattle extends AppCompatActivity {

    private String picPosition;
    private Button startAuction;
    private ImageView imageHolder;

    private String[] age = {"18 - 24 months","1 - 2 years","2 - 3 years"};
    private String[] sex = {"Calf","Heifer","Bull"};
    private String[] description = {"Very energetic, Graze well","Well fed, beautiful skin patterns","Strong and healthy, able to breed"};

    EditText displayAge, displaySex, displayDescription, bid_amount, closing_date;
    TextView minBid, dateTXT;
    Random randomGen = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_auction_cattle);

        //get value of selected cow
        Intent getPreviousIntent = getIntent();
        picPosition = getPreviousIntent.getStringExtra("position");

        // set image based on the selected cow
        imageHolder = (ImageView)findViewById(R.id.imageView2);

        switch(picPosition)
        {
            case "First Cow":{ imageHolder.setImageResource(R.drawable.cow1); break;}
            case "Second Cow":{ imageHolder.setImageResource(R.drawable.cow2); break;}
            case "Third Cow":{ imageHolder.setImageResource(R.drawable.cow3); break;}
            case "Forth Cow":{ imageHolder.setImageResource(R.drawable.cow4); break;}
            case "Fifth Cow":{ imageHolder.setImageResource(R.drawable.cow5); break;}
        }

        // First inital text components
        displayAge = (EditText)findViewById(R.id.editText2);
        displaySex = (EditText)findViewById(R.id.editText5);
        displayDescription = (EditText)findViewById(R.id.ola);

        int randInt = randomGen.nextInt(3); // from 0 - 2

        //randomly set age, sex and description
        displayAge.setText(age[randInt]);
        displaySex.setText(sex[randInt]);
        displayDescription.setText(description[randInt]);

        //create action listner for the button
        startAuction = (Button)findViewById(R.id.buttonBTN);
        startAuction.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view)
            {
                if( !bid_amount.getText().toString().isEmpty() && !closing_date.getText().toString().isEmpty())
                {
                    startAuction.setBackgroundColor(getResources().getColor(R.color.cgreen));
                    popUp("You have sucessfully opened an auction","Auction Open");

                    Intent intent = new Intent(AuctionCattle.this, MainActivity.class);
                    AuctionCattle.this.startActivity(intent);


                }else
                {
                    //Make amount and closing date compnents visible to the user
                    // Also change change button color to green to indicate user is still in progress
                    startAuction.setBackgroundColor(getResources().getColor(R.color.cYellow));
                    minBid.setVisibility(View.VISIBLE);
                    dateTXT.setVisibility(View.VISIBLE);
                    bid_amount.setVisibility(View.VISIBLE);
                    closing_date.setVisibility(View.VISIBLE);

                }

            }
        });

        //Make amount and closing date not visible to the user
       bid_amount = (EditText)findViewById(R.id.amountTXA);
        closing_date = (EditText)findViewById(R.id.dateTXA);

       bid_amount.setVisibility(View.INVISIBLE);
        closing_date.setVisibility(View.INVISIBLE);

        //initial min bid and date textview components
        minBid = (TextView)findViewById(R.id.minBid);
        dateTXT = (TextView)findViewById(R.id.dateTXT);

        minBid.setVisibility(View.INVISIBLE);
        dateTXT.setVisibility(View.INVISIBLE);


    }

    private void popUp(String message, String title)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(AuctionCattle.this);
        alert.setMessage(message).setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setTitle(title).create();
        alert.show();
    }
}

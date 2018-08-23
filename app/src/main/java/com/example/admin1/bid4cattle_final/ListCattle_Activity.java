package com.example.admin1.bid4cattle_final;

import android.app.Activity;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class ListCattle_Activity extends AppCompatActivity {

    ListView list;

    String web[] = {"First Cow","Second Cow","Third Cow","Forth Cow","Fifth Cow"};
    Integer imageID[] = {R.drawable.cow1, R.drawable.cow2, R.drawable.cow3, R.drawable.cow4, R.drawable.cow5};

    Sell_List adapter;
    String ola;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
        Intent intent = getIntent();
        String fromPrevious = intent.getStringExtra("last");
        popUp("ola",fromPrevious);

        switch (fromPrevious)
        {
            case "last":
                {
                    populateList(BuyCattle.class);
                    break;

                }
            case "first":
                {
                    populateList(AuctionCattle.class);
                    break;

                }
        }

    }

    public void populateList(final Class className) {
        adapter = new Sell_List(ListCattle_Activity.this, web, imageID);
        list = (ListView) findViewById(R.id.list);
        list.setAdapter(adapter);
        list.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                // Toast.makeText(ListCattle_Activity.this, "You clicked at " + web[+position], Toast.LENGTH_SHORT).show();
                Intent nextScreen = new Intent(ListCattle_Activity.this, className);
                nextScreen.putExtra("position", web[+position]);
                ListCattle_Activity.this.startActivity(nextScreen);
            }
        });
    }
    private void popUp(String message, String title)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(ListCattle_Activity.this);
        alert.setMessage(message).setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setTitle(title).create();
        alert.show();
    }
}


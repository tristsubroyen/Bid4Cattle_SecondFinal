package com.example.admin1.bid4cattle_final.Presentation_Layer;

import android.support.v7.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;
import android.widget.Spinner;
import android.widget.ArrayAdapter;
import com.example.admin1.bid4cattle_final.R;

public class AddCattle extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);
        //Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        // setSupportActionBar(toolbar);

        Spinner dropdown = (Spinner) findViewById(R.id.spinner1);
        String[] items = new String[]{"0 - 6", "6 - 12", "12 - 24", "24 - 36", "36 - 48", "Older"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items);
        dropdown.setAdapter(adapter);
        Spinner dropdown1 = (Spinner) findViewById(R.id.spinner2);
        String[] items1 = new String[]{"Male", "Female"};
        ArrayAdapter<String> adapter1 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_dropdown_item, items1);
        dropdown1.setAdapter(adapter1);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            // Handle the camera action
        } else if (id == R.id.nav_add) {
            Toast.makeText(AddCattle.this, "You clicked at ", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(this, AddCattle.class);
            startActivity(intent);


        } else if (id == R.id.nav_sell) {
            Intent nextActivity = new Intent(AddCattle.this, ListCattle_Activity.class);
            nextActivity.putExtra("last","first");

            startActivity(nextActivity);

        } else if (id == R.id.nav_manage) {
            Intent intent = new Intent(this, ListCattle_Activity.class);
            intent.putExtra("last","last");
            startActivity(intent);

        }

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}


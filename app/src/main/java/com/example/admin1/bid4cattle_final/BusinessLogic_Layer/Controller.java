package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;

import com.example.admin1.bid4cattle_final.Database_Layer.DBHandler;

import java.io.Serializable;

public class Controller  {

    private User user;
    Context context;
    DBHandler dbHandler;
    public Controller(String name, String surname, String city, String email, String password, Context context) {
        this.user = new User(name, surname, city, email, password);
    }

    public boolean checkDatabase() {
        SQLiteDatabase checkDB = null;
        try {
            checkDB = SQLiteDatabase.openDatabase(String.valueOf(context.getDatabasePath("bid4cows")), null,
                    SQLiteDatabase.OPEN_READONLY);
            checkDB.close();
        } catch(SQLiteException e) {
            e.printStackTrace();
            System.out.println("The database does not exist.");
        }
        return checkDB != null;
    }




}

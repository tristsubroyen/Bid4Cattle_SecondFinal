package com.example.admin1.bid4cattle_final.Database_Layer;

import android.database.sqlite.SQLiteDatabase;

/**
 * Created by admin1 on 2018/09/04.
 */

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteStatement;

import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Auction;
import com.example.admin1.bid4cattle_final.BusinessLogic_Layer.Cattle;

import java.util.ArrayList;
import java.util.List;

public class DBHandler extends SQLiteOpenHelper {
    // Database Version
    private static final int DATABASE_VERSION = 1;

    // Database Name
    private static final String DATABASE_NAME = "bid4cows";

    // Contacts table name
    private static final String TABLE_Users = "users";
    private static final String TABLE_Cattle = "cattle";
    private static final String TABLE_Auction = "auction";
    private static final String TABLE_Sales = "sales";


    // Users Table Columns names
    private static final String userID = "user_id";
    private static final String userName = "name";
    private static final String userSurname = "surname";
    private static final String userLocation = "location";
    private static final String userEmail = "email";
    private static final String userPassword = "password";

    // Cattle Table Columns names
    private static final String cattleID = "cattle_id";
    private static final String cattle_userID = "user_id";
    private static final String cattleSex = "sex";
    private static final String cattleDescription = "description";
    private static final String cattleImage = "image";
    private static final String cattleLocation = "location";
    private static final String cattleAge = "age";
    private static final String cattleBreed = "breed";


    // Auction Table Columns names
    private static final String auctionID = "auction_id";
    private static final String auction_userID = "userID";
    private static final String auctionAmount = "amoount";
    private static final String auctionStartDate = "startDate";
    private static final String auctionClosingDate = "closingDate";
    private static final String auctionMinIncrement = "minimum_increment";
    private static final String auctionClosed = "closed";

    //Sales Table Columns names
    private static final String salesID = "sales_id";
    private static final String sales_userID = "user_id";
    private static final String salesNoOfUnitsSold = "units_sold";
    private static final String salesTotalAmount = "total_amount";
    private static final String salesDate = "date";

    public ArrayList<Cattle> cattleList;
    public ArrayList<Auction> auctionList;


    public DBHandler(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        this.cattleList = new ArrayList<>();
        this.auctionList = new ArrayList<>();

        //Create Users Table
        String CREATE_USERS_TABLE = "CREATE TABLE " + TABLE_Users + " ("
                + userID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + userName + " TEXT,"
                + userSurname + " TEXT, " + userLocation + " TEXT, " + userEmail + " TEXT, " + userPassword + " TEXT)";
        db.execSQL(CREATE_USERS_TABLE);

        //Create Cattle Table
        String CREATE_CATTLE_TABLE = "CREATE TABLE " + TABLE_Cattle
                + " (" + cattleID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + cattleAge + " TEXT," + cattleSex + " TEXT, "
                + cattleBreed + " TEXT, " + cattleDescription + " TEXT, " + cattleLocation + " TEXT," + cattleImage + " BLOB," + userID + "  INTEGER, FOREIGN KEY(" + userID + ") REFERENCES " + TABLE_Users + "(" + userID + ")  )";
        db.execSQL(CREATE_CATTLE_TABLE);


        //Create Auction Table
        String CREATE_AUCTIO_TABLE = "CREATE TABLE " + TABLE_Auction
                + " (" + auctionID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + auctionAmount + " DECIMAL," + auctionStartDate + " TEXT,"
                + auctionClosingDate + " TEXT, " + auctionMinIncrement + " DECIMAL, " + auctionClosed + " TEXT, " + userID + "  INTEGER, "+ cattleID+" INTEGER, FOREIGN KEY(" + userID +
                ") REFERENCES " + TABLE_Users + "(" + userID + "), FOREIGN KEY ("+ cattleID+") REFERENCES " + TABLE_Cattle +" ("+ cattleID+"))";
        db.execSQL(CREATE_AUCTIO_TABLE);

        //Create Sales Table
        String CREATE_SALES_TABLE = "CREATE TABLE " + TABLE_Sales
                + " (" + salesID + " INTEGER PRIMARY KEY AUTOINCREMENT, " + salesNoOfUnitsSold + " INTEGER," + salesTotalAmount + " DECIMAL,"
                + salesDate + " TEXT, " + userID + "  INTEGER, FOREIGN KEY(" + userID + ") REFERENCES " + TABLE_Users + "(" + userID + ")  )";
        db.execSQL(CREATE_SALES_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // Drop older table if existed
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Sales);
        // Creating tables again
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Cattle);
        // Creating tables again
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Auction);
        // Creating tables again
        onCreate(db);

        db.execSQL("DROP TABLE IF EXISTS " + TABLE_Sales);
        // Creating tables again
        onCreate(db);
    }

    public void insertNewUser(int id, String name, String surname, String location, String email, String password) {
        //This methods inserts a new user to the user table
        SQLiteDatabase database = getReadableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(userID, id);
        contentValues.put(userName, name);
        contentValues.put(userSurname, surname);
        contentValues.put(userLocation, location);
        contentValues.put(userEmail, email);
        contentValues.put(userPassword, password);

        database.insert(TABLE_Users, null, contentValues);
        database.close();
    }

}

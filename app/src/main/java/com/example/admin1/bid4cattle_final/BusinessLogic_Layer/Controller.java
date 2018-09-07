package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

import android.content.Context;
import android.content.DialogInterface;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.os.Parcel;
import android.os.Parcelable;
import android.support.v7.app.AlertDialog;

import com.example.admin1.bid4cattle_final.Database_Layer.DBHandler;
import com.example.admin1.bid4cattle_final.Presentation_Layer.AuctionCattle;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Controller  {

    private User user;
    private ArrayList<String> usersList;
    private Random randomizer;


    public Controller()
    {
        this.usersList = new ArrayList<>();
        this.randomizer = new Random();
    }

    public ArrayList<String> read_data(String fileName)
    {
        ArrayList<String> data  = new ArrayList<>();

        try
        {
            File file  = new File(fileName);
            Scanner scanner  = new Scanner(file);

            while(scanner.hasNext())
            {
                String line = scanner.nextLine();
                data.add(line);
            }
        }catch (FileNotFoundException error)
        {
            System.out.println("Could not read data " + fileName +":\n" + error.getMessage());
        }
         return data;
    }

    public boolean save_data(String fileName, String data)
    {
        //save data to the database
        boolean success = false;

        try
        {
            FileWriter fileWriter = new FileWriter(".//Database_Layer/"+fileName, true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(data);

            bufferedWriter.close();
            fileWriter.close();

            success = true;

        }catch(IOException error)
        {
            System.out.println("Could not save data :\n" + error.getMessage());
        }
        return success;
    }

    public boolean check_Login(String email, String password)
    {
        //Retreive user data based on the given
        boolean flag = false; // should this value be return the user data was not found on the database

        try
        {
            File open = new File("bid4cattle_final\\Database_Layer\\Users.txt");
            Scanner read = new Scanner(open);

            while(read.hasNext())
            {
                String line = read.nextLine();
                String read_email = line.split(",")[4];
                String read_password = line.split(",")[5];
                if(read_email.equals(email)) //check to see if the user email has been found
                {
                    if(read_password.equals(password))
                    {
                        flag = true;
                        break;
                    }
//C:\Users\trist\Documents\2018\CSC3003S\Bid4Cattle_Stage3\Bid4Cattle_Final\app\src\main\java\com\example\admin1\bid4cattle_final\Database_Layer\Users
                }
            }
            read.close();
        }catch(Exception error)
        {
            System.out.printf("Could not retreive user data :\n" + error.getMessage());
        }
        return flag;
    }

    //Setters
    public void setUser(String id, String name, String surname,  String city, String email, String password)
    {
        //creates new user object
        this.user = new User(id, name, surname, city, email, password);
    }

    //Getters
    public int getRandomInt(){ return this.randomizer.nextInt();}
    public double getRandomDouble(){return  this.randomizer.nextDouble();}
    public String getUserDetails(){ return  this.user.toString();}




    //For pop ups on the screen
    public void popUp(String message, String title, Context context)
    {
        AlertDialog.Builder alert = new AlertDialog.Builder(context);
        alert.setMessage(message).setPositiveButton("Continue", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {

            }
        }).setTitle(title).create();
        alert.show();
    }

}

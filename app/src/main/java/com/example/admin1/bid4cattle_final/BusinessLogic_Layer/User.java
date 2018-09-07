package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

public class User {

    private String id,name,surname, location, email, password;

    public User(String id, String name, String surname, String location, String email, String password)
    {
        this.id = id;
        this.name = name;
        this.surname = surname;
        this.location = location;
        this.email = email;
        this.password = password;
    }

    public String getName(){ return this.name;}
    public String getSurname(){ return this.surname;}
    public String getLocation(){ return this.location;}
    public String getEmail(){ return this.email;}
    public String getPassword(){ return this.password;}
    public String getID(){return this.id;}

    public String toString()
    {
        return this.id + ","+ this.name +","+ this.surname +","+ this.location +","+ this.email; //not returning password
    }

}

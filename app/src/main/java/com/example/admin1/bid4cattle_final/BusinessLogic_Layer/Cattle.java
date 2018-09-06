package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

public class Cattle {

    private byte[] cattleImage;
    private int cattleID, userID;
    private String sex, age, location, breed, description;

    public Cattle(int userID, int cattleID, byte[] image, String sex, String age, String breed, String description, String location)
    {
        this.userID = userID;
        this.cattleID = cattleID;
        this.cattleImage = image;
        this.sex = sex;
        this.age = age;
        this.breed = breed;
        this.description = description;
        this.location = location;
    }

    //Getters
    public int getUserID(){ return this.userID;}
    public int getCattleID(){ return this.cattleID;}
    public byte[] getCattleImage(){ return  this.cattleImage;}

    public String getSex(){ return this.sex;}
    public String getLocation(){ return this.location;}
    public String getAge(){ return this.age;}
    public String getBreed(){ return this.breed;}
    public String getDescription(){ return this.description;}

    //Setters
    public void setCattleImage(byte[] incoming_image){ this.cattleImage = incoming_image;}
    public void setCattleID(int incoming_id){ this.cattleID = incoming_id;}
    public void setUserID(int incoming_userID){ this.userID = incoming_userID;}

    public void setSex(String incoming_sex){ this.sex = incoming_sex;}
    public void setAge(String incoming_sex){ this.age = incoming_sex;}
    public void setLocation(String incoming_location){ this.location = incoming_location;}

    public void setBreed(String incoming_breed){ this.breed = incoming_breed;}
    public void setDescription(String incoming_description){ this.description = incoming_description;}




}

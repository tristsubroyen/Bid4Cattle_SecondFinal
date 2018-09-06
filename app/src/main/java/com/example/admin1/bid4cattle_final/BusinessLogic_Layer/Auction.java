package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

public class Auction <K extends Integer, V extends String, X extends Double>
{
    private K auctionID;
    private V clientFullName;
    private V startDate, closingDate;
    private X initialAmount, minIncrement;
    private K cattleID;


    public Auction(K id, V name, X amount, V start, V end, K cattleID)
    {
        this.auctionID = id;
        this.clientFullName = name;
        this.initialAmount = amount;
        this.startDate = start;
        this.closingDate = end;
        this.cattleID = cattleID;
    }

    //Get methods
    public K getAuctionID(){ return this.auctionID;}
    public V getClientFullName(){ return this.clientFullName;}
    public V getStartDate() {return this.startDate;}
    public V getEndDate() {return this.closingDate;}
    public X getMinimumIncrement(){ return this.minIncrement;}
    public K getCattleID(){ return this.cattleID;}

    //Set methods
    public void setAmount(X newBidAmount)
    {
        this.initialAmount = newBidAmount;
    }
    public void setEndDate(V newClosingDate)
    {
        this.closingDate = newClosingDate;
    }
    public void setMinimumIncrement(X minIncr){ this.minIncrement = minIncr; }

}


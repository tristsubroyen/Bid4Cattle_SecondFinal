package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

public class Auction <K extends Number, V extends String>
{
    private K auctionID;
    private V clientFullName;
    private V startDate, closingDate;
    private K initialAmount;

    public Auction(K id, V name, K amount, V start, V end)
    {
        this.auctionID = id;
        this.clientFullName = name;
        this.initialAmount = amount;
        this.startDate = start;
        this.closingDate = end;
    }

    //Get methods
    public K getAuctionID(){ return this.auctionID;}
    public V getClientFullName(){ return this.clientFullName;}
    public V getStartDate() {return this.startDate;}
    public V getEndDate() {return this.closingDate;}

    //Set methods
    public void setAmount(K newBidAmount)
    {
        this.initialAmount = newBidAmount;
    }

    public void setEndDate(V newClosingDate)
    {
        this.closingDate = newClosingDate;
    }

}

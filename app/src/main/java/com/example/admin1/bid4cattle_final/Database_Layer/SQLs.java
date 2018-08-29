package com.example.admin1.bid4cattle_final.Database_Layer;

/**
 * Created by admin1 on 2018/08/29.
 */

public class SQLs
{
    public SQLs(){}

    public void placeBid(String table_name,int auctionID, int userID, double newBidAmount)
    {
        try
        {
            String SQL = "UPDATE Table " + table_name + " SET ID = " + userID+", BID = " + newBidAmount + " WHERE AuctionID = " + auctionID;
        }catch (Exception error){}
    }
}

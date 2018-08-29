package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;
import com.example.admin1.bid4cattle_final.Database_Layer.SQLs;

/**
 * Created by admin1 on 2018/08/29.
 */

public class PlaceBid<K extends Number, V extends K, Q extends Integer, X extends Q >
{
    private K bid;
    private V currentAmount;
    private Q auctionID;
    private X userID;
    private final double limit = 20000.00; //needs a review
    private SQLs SQL_Object;

    public PlaceBid(Q auctionID, X userID, K newBid, V recentAmount, int id)
    {
        this.auctionID = auctionID;
        this.userID = userID;
        this.bid = newBid;
        this.currentAmount = recentAmount;

        try
        {
            if(checkLimit())
            {
                this.SQL_Object = new SQLs();

                submitBid(this.userID, this.auctionID, this.bid, this.currentAmount); // placing bit to the DB/Server


            }
        }catch(Exception error){}
    }

    private boolean checkLimit() //this method will check if the bid placed does not exceed bidding limits
    {
        boolean flag = false;
        if((this.currentAmount.doubleValue() + this.bid.doubleValue()) > 20000)
        {
            flag = true;
        }
        return flag;
    }

    private void submitBid(X userID, Q auctionID, K newBid, V currentAmount)
    {
        this.SQL_Object.placeBid("Bids", auctionID.intValue(),  userID.intValue(), (newBid.doubleValue() + currentAmount.doubleValue()) );
    }
}

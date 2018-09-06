package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by admin1 on 2018/08/30.
 */

public class InitiateAuction<K extends Integer, V extends String, X extends Double> extends Auction
{
    private Cattle cattleOnAuction;

    public InitiateAuction(K auctionID, V fullName, X initialAmount,V startDate, V closingDate, Cattle cattle)
    {
        super(auctionID, fullName, initialAmount, startDate, closingDate, cattle.getCattleID());
        this.cattleOnAuction = cattle;
    }

    public void setMinIncrement(X minIncr) {super.setMinimumIncrement(minIncr);}
    public Cattle getCattle(){ return this.cattleOnAuction;}



}

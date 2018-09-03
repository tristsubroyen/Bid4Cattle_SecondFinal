package com.example.admin1.bid4cattle_final.BusinessLogic_Layer;

import java.util.Date;
import java.text.SimpleDateFormat;

/**
 * Created by admin1 on 2018/08/30.
 */

public class InitiateAuction<K extends Number, V extends String> extends Auction
{

    public InitiateAuction(K auctionID, V fullName, K initialAmount,V startDate, V closingDate)
    {
        super(auctionID, fullName, initialAmount, startDate, closingDate);


    }

    /*
    private String getCurrentDate()
    {
        //This method will return the current date
        SimpleDateFormat dateFormator = new SimpleDateFormat("yyyy/MM/dd");
        Date dat = new Date();

        String currentDate = dateFormator.format(dat);
        return currentDate;
    }*/


}

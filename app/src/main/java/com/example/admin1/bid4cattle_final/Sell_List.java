package com.example.admin1.bid4cattle_final;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Created by admin1 on 2018/08/15.
 */

public class Sell_List extends ArrayAdapter<String>
{
    private final Activity context;
    private final String[] web;
    private final Integer[] imageID;

    public Sell_List(Activity context, String[] web, Integer[] imageID)
    {
        super(context, R.layout.sell_list,web);
        this.context = context;
        this.web = web;
        this.imageID = imageID;
    }

    public View getView(int position, View view, ViewGroup parent)
    {
        LayoutInflater inflater = context.getLayoutInflater();
        View rowViewer  = inflater.inflate(R.layout.sell_list, null, true);
        TextView textTitle = (TextView)rowViewer.findViewById(R.id.text);

        ImageView imageView = (ImageView)rowViewer.findViewById(R.id.images);
        textTitle.setText(web[position]);

        imageView.setImageResource(imageID[position]);
        return rowViewer;
    }

}

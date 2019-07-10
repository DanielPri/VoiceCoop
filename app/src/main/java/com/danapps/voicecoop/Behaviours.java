package com.danapps.voicecoop;

import android.graphics.Color;
import android.graphics.Paint;
import android.widget.TextView;

public class Behaviours {

    public static void toggleNumber(TextView txtview){
        if(txtview.getCurrentTextColor() == Color.RED){
            txtview.setPaintFlags(txtview.getPaintFlags() & (~ Paint.STRIKE_THRU_TEXT_FLAG));
            txtview.setTextColor(Color.BLACK);
        } else {
            txtview.setTextColor(Color.RED);
            txtview.setPaintFlags(txtview.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }

    public static void makeNumberRed(TextView txtview){
        if(txtview.getCurrentTextColor() == Color.RED){
            return;
        } else {
            txtview.setTextColor(Color.RED);
            txtview.setPaintFlags(txtview.getPaintFlags() | Paint.STRIKE_THRU_TEXT_FLAG);
        }

    }

}

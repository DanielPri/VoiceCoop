package com.danapps.voicecoop;

import android.content.Context;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.TextView;

import java.util.ArrayList;

public class numberAdapter extends BaseAdapter {

    private int[] numbers;
    private Context context;
    private ArrayList<Coop> coops;

    numberAdapter(int qty, Context context, ArrayList<Coop> coops){
        this.context = context;
        numbers = new int[qty];
        for(int i = 1; i <= qty; i++){
            numbers[i-1] = i;
        }
        this.coops = coops;
    }

    @Override
    public int getCount() {
        return numbers.length;
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int index, View view, ViewGroup viewGroup) {
        final TextView txtview;
        if(view == null){
            txtview = new TextView(context);
            txtview.setLayoutParams(new GridView.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
            txtview.setPadding(10,10,10,10);
            txtview.setTextSize(30);
            txtview.setTextColor(Color.BLACK);
            txtview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Behaviours.toggleNumber(txtview);
                    coops.get(Integer.parseInt(txtview.getText().toString())-1).toggleComplete();
                }
            });
        }
        else{
            txtview = (TextView) view;
        }
        txtview.setText(Integer.toString(numbers[index]));
        return txtview;
    }
}

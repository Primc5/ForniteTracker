package com.u_tad.fornitetracker;

import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class ViewModelForniteUser extends  RecyclerView.ViewHolder {
    private TextView txt_title;
    private TextView txt_value;
    private TextView txt_rank;



    public ViewModelForniteUser(@NonNull View itemView) {
        super(itemView);
        txt_title = itemView.findViewById(R.id.txt_card_title);
        txt_value = itemView.findViewById(R.id.txt_card_value);
        txt_rank = itemView.findViewById(R.id.txt_card_rank);

    }

    public void setTitle(String txt_title){
        this.txt_title.setText(txt_title);
    }

    public void setValue(String txt_value){
        this.txt_value.setText(txt_value);
    }

    public void setRank(String txt_rank){
        this.txt_rank.setText(txt_rank);
    }
}

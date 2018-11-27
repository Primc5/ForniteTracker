package com.u_tad.fornitetracker;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterFornitePlayers extends RecyclerView.Adapter<ViewHolderForniteUser> {

    private ArrayList<ForniteUser.Stats.EachStat.Stat> arrayList;


    public AdapterFornitePlayers(ArrayList<ForniteUser.Stats.EachStat.Stat> arrayList){
        this.arrayList = arrayList;
    }



    @Override
    public ViewHolderForniteUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_fornite_player,null);
        ViewHolderForniteUser modulesViewHolder = new ViewHolderForniteUser(view);
        return modulesViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderForniteUser viewHolderForniteUser, int i) {
        ForniteUser.Stats.EachStat.Stat item = arrayList.get(i);
        Log.d("titulo", arrayList.get(i).getValue());
        viewHolderForniteUser.setTitle(item.getLabel());
        viewHolderForniteUser.setValue(item.getValue());
        viewHolderForniteUser.setRank(item.getRank().toString());
    }




    @Override
    public int getItemCount() {
        return arrayList.size();
    }


}
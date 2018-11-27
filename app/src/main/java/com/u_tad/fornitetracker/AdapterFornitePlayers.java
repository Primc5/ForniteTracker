package com.u_tad.fornitetracker;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class AdapterFornitePlayers extends RecyclerView.Adapter<ViewModelForniteUser> {

    private ArrayList<ForniteUser> modules;
    private Context mContext;
    private ViewModelForniteUser viewModelForniteUser;

    public AdapterFornitePlayers(ArrayList<ForniteUser> modules){
        this.modules = modules;
    }


    @Override
    public ViewModelForniteUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_fornite_player,null);
        ViewModelForniteUser modulesViewHolder = new ViewModelForniteUser(view);
        return modulesViewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull final ViewModelForniteUser viewModelForniteUser, int i) {

    }


    @Override
    public int getItemCount() {
        return 2;
    }


}
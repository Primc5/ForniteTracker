package com.u_tad.fornitetracker;


import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Locale;

public class AdapterFornitePlayers extends RecyclerView.Adapter<ViewHolderForniteUser> {

    private ArrayList<ForniteUser> modules;


    public AdapterFornitePlayers(ArrayList<ForniteUser> modules){
        this.modules = modules;
    }


    @Override
    public ViewHolderForniteUser onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_view_fornite_player,null);
        ViewHolderForniteUser modulesViewHolder = new ViewHolderForniteUser(view);
        return modulesViewHolder;
    }

    @Override
    public void onBindViewHolder(ViewHolderForniteUser viewHolderForniteUser, int i) {
        final ForniteUser user = modules.get(i);
        setData(viewHolderForniteUser, user);
    }


    public void setData(ViewHolderForniteUser viewHolderForniteUser, ForniteUser user){
        viewHolderForniteUser.setTitle(user.getStats().getPlayer().getTitle());
        viewHolderForniteUser.setValue(user.getStats().getPlayer().getValue());
        viewHolderForniteUser.setRank(user.getStats().getPlayer().getRank());
    }

    @Override
    public int getItemCount() {
        return 2;
    }


}
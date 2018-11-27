package com.u_tad.fornitetracker;


import android.arch.lifecycle.ViewModelProviders;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AdapterFornitePlayers adapter;
    private RecyclerView recyclerView;
    private FloatingActionButton search;
    private EditText userName;
    private ArrayList<ForniteUser> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewStuffs();


        search();

        getData("xPrimcx");
    }

    public void setViewStuffs(){
        recyclerView = findViewById(R.id.recycler_view_notice_list);
        search = findViewById(R.id.search);
        userName = findViewById(R.id.textView_user);
    }

    public void loadView(ArrayList<ForniteUser> arrayList){

        adapter = new AdapterFornitePlayers(arrayList);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(MainActivity.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(adapter);
    }

    private void search() {
        search.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Here's a Snackbar", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
                getData(userName.getText().toString());
            }
        });
    }

    public void getData(String userNickName){
        ViewModelForniteUser viewModelForniteUser = ViewModelProviders.of(this).get(ViewModelForniteUser.class);
        viewModelForniteUser.liveData.observe(this, changes -> {
            if (changes != null) {
                Log.d("ServicioGithub ", "Cambios " + changes.toString());
                loadView(changes);
            }
        });
        viewModelForniteUser.getData(userNickName);
    }
}

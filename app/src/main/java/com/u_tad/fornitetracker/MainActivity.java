package com.u_tad.fornitetracker;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Adapter;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private AdapterFornitePlayers adapter;
    private RecyclerView recyclerView;
    private Button search;
    private EditText userName;
    private ArrayList<ForniteUser> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setViewStuffs();

        loadView(arrayList);

        search();

        getData("xPrimcx");
    }

    public void setViewStuffs(){
        recyclerView = findViewById(R.id.recycler_view_notice_list);
        search = findViewById(R.id.button_search);
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
            public void onClick(View v) {
                getData(userName.getText().toString());
            }
        });
    }

    public void getData(String userNickName){

    }
}

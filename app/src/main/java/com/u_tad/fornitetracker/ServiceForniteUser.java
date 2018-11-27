package com.u_tad.fornitetracker;

import android.database.Observable;
import android.os.Build;
import android.support.annotation.RequiresApi;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;



import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Query;


public interface ServiceForniteUser {

    @Headers("TRN-Api-Key: 13168a3f-e5b8-438c-8068-5902fd438239")
    @GET("v1/profile/pc/")
    Observable<ArrayList<ForniteUser>> loadUser(@Query("user") String user);


    static ServiceForniteUser Factory(){
        Gson gsonBuilder = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .build();
        return  retrofit.create(ServiceForniteUser.class);
    }
}

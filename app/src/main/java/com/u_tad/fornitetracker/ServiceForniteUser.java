package com.u_tad.fornitetracker;

import io.reactivex.Observable;


import com.google.gson.Gson;
import com.google.gson.GsonBuilder;


import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.Headers;
import retrofit2.http.Path;


public interface ServiceForniteUser {

    @Headers("TRN-Api-Key: 13168a3f-e5b8-438c-8068-5902fd438239")
    @GET("profile/{plataform}/{epic-nickname}")
    Observable <ForniteUser> loadUser(@Path("epic-nickname") String user, @Path("plataform") String plataform);


    static ServiceForniteUser Factory(){
        Gson gsonBuilder = new GsonBuilder()
                .setLenient()
                .create();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.fortnitetracker.com/v1/")
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(gsonBuilder))
                .build();
        return  retrofit.create(ServiceForniteUser.class);
    }
}

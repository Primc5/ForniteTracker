package com.u_tad.fornitetracker;

import io.reactivex.Observable;

import java.util.ArrayList;

public class RepositorieForniteUser {

    private static volatile RepositorieForniteUser ourInstance = new RepositorieForniteUser();

    static RepositorieForniteUser getInstance() {
        if (ourInstance == null) {
            synchronized (RepositorieForniteUser.class) {
                if (ourInstance == null) {
                    ourInstance = new RepositorieForniteUser();
                }
            }
        }
        return ourInstance;
    }

    private RepositorieForniteUser() {
    }


    private ServiceForniteUser forniteApi = ServiceForniteUser.Factory();


    public Observable<ArrayList<ForniteUser>> getUsers(String nick){
        return forniteApi.loadUser(nick);
    }

}

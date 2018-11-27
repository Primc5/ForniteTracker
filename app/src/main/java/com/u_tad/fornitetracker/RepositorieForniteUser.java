package com.u_tad.fornitetracker;

import io.reactivex.Observable;

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


    public Observable <ForniteUser> getUsers(String nick, String plataform){
        return forniteApi.loadUser(nick, plataform);
    }

}

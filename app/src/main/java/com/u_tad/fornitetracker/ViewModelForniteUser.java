package com.u_tad.fornitetracker;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;


import io.reactivex.Observer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.schedulers.Schedulers;

public class ViewModelForniteUser extends ViewModel {

    private RepositorieForniteUser repositorieForniteUser = RepositorieForniteUser.getInstance();
    public MutableLiveData<ArrayList<ForniteUser>> liveData = new MutableLiveData<>();

    public void getData(String nick){

        repositorieForniteUser.getUsers(nick)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(new Observer<ArrayList<ForniteUser>>() {


                    @Override
                    public void onSubscribe(Disposable d) {

                    }

                    @Override
                    public void onNext(ArrayList<ForniteUser> changes) {
                        liveData.postValue(changes);
                        Log.d("Recibiendo", "...");
                    }

                    @Override
                    public void onError(Throwable e) {
                        Log.d("FalloServicio","err: "+e.getLocalizedMessage());
                    }

                    @Override
                    public void onComplete() {

                    }
                });
    }


}

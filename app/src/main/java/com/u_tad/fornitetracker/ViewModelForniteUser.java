package com.u_tad.fornitetracker;


import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.util.Log;

import java.util.ArrayList;


import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class ViewModelForniteUser extends ViewModel {

    private RepositorieForniteUser repositorieForniteUser = RepositorieForniteUser.getInstance();
    public MutableLiveData <ForniteUser.Stats.EachStat.Stat> liveData = new MutableLiveData<>();

    private ArrayList<ForniteUser.Stats.EachStat.Stat> arr_parameters = new ArrayList<>();
    private MutableLiveData <ArrayList<ForniteUser.Stats.EachStat.Stat>> dataUserMutableLiveData = new MutableLiveData<>();


    private MutableLiveData<ForniteUser> fortniteUserMutableLiveData = new MutableLiveData<>();

    public void getData(String nick, String plataform){

        repositorieForniteUser.getUsers(nick, plataform)
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeOn(Schedulers.io())
                .subscribe(response ->  {
                            arr_parameters.add(response.getStats().getP10().getWinRatio());
                            arr_parameters.add(response.getStats().getP10().getKd());
                            arr_parameters.add(response.getStats().getP10().getKills());
                            arr_parameters.add(response.getStats().getP10().getMatches());

                            dataUserMutableLiveData.postValue(arr_parameters);
                            //dataUserMutableLiveData.postValue(arr_parameters);
                            Log.d("Service response", "todo correcto aqui");
                            Log.d("test", response.getStats().getP10().getWinRatio().toString());
                        },
                        error -> Log.d("SERVICE RESPONSE", error.getLocalizedMessage()));

    }


    public MutableLiveData<ArrayList<ForniteUser.Stats.EachStat.Stat>> getDataMutableLiveData() {
        return dataUserMutableLiveData;
    }


}

package com.kel6.kel6laundry.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;
import androidx.lifecycle.LiveData;

import com.kel6.kel6laundry.database.DatabaseClient;
import com.kel6.kel6laundry.database.dao.LaundryDao;
import com.kel6.kel6laundry.model.ModelLaundry;

import java.util.List;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Completable;
import io.reactivex.rxjava3.schedulers.Schedulers;


public class LaundryViewModel extends AndroidViewModel {

    LiveData<List<ModelLaundry>> mModelLaundry;
    LaundryDao laundryDao;

    public LaundryViewModel(@NonNull Application application) {
        super(application);

        laundryDao = DatabaseClient.getInstance(application).getAppDatabase().laundryDao();
        mModelLaundry = laundryDao.getAll();
    }

    public LiveData<List<ModelLaundry>> getDataLaundry() {
        return mModelLaundry;
    }

    public void deleteDataById(final int uid) {
        Completable.fromAction(() -> laundryDao.deleteSingleData(uid))
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe();
    }

}

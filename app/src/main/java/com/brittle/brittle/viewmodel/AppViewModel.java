package com.brittle.brittle.viewmodel;

import android.app.Application;

import androidx.annotation.NonNull;
import androidx.lifecycle.AndroidViewModel;

import com.brittle.brittle.model.GroceryItem;
import com.brittle.brittle.repository.AppRepo;

public class AppViewModel extends AndroidViewModel {
    private final AppRepo appRepo;

    public AppViewModel(@NonNull Application application) {
        super(application);

        appRepo = new AppRepo(application);
    }

    /********************************** Local data **********************************************/
    public void saveWifiToken(@NonNull GroceryItem wifiToken) {
        appRepo.saveGroceryItem(wifiToken);
    }

    public void updateQuota(@NonNull GroceryItem wifiToken) {
        appRepo.updateGroceryItem(wifiToken);
    }


    @NonNull
    public GroceryItem getToken() {
        return appRepo.getGroceryItem();
    }
    /********************************** Local data **********************************************/
}

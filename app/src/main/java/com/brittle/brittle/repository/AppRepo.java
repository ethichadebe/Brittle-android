package com.brittle.brittle.repository;

import android.content.Context;

import androidx.annotation.NonNull;

import com.brittle.brittle.database.BrittleDatabase;
import com.brittle.brittle.model.GroceryItem;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.Executor;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AppRepo {

    BrittleDatabase brittleDatabase;
    private Executor executor = Executors.newSingleThreadExecutor();

    public AppRepo(@NonNull Context context) {
        brittleDatabase = BrittleDatabase.getInstance(context);
    }


    /********************************** Local data **********************************************/

    public void saveGroceryItem(@NonNull GroceryItem groceryItem) {
        executor.execute(() -> brittleDatabase.appDao().saveGroceryItem(groceryItem));
    }

    @NonNull
    public GroceryItem getGroceryItem() {
        Callable<GroceryItem> callable = () -> brittleDatabase.appDao().getGroceryItem();

        Future<GroceryItem> future = Executors.newSingleThreadExecutor().submit(callable);

        try {
            return future.get();
        } catch (ExecutionException | InterruptedException e) {
            throw new RuntimeException(e);
        }
    }

    public void updateGroceryItem(@NonNull GroceryItem groceryItem) {
        executor.execute(() -> brittleDatabase.appDao().updateGroceryItem(groceryItem));
    }

    /********************************** Local data **********************************************/
}

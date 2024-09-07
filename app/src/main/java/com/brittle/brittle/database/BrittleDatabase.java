package com.brittle.brittle.database;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.brittle.brittle.model.GroceryItem;


@Database(entities = GroceryItem.class, version = 3)
public abstract class BrittleDatabase extends RoomDatabase {
    public static final String DATABASE_NAME = "brittleDatabase.db";
    public static volatile BrittleDatabase instance;
    public static final Object LOCK = new Object();

    @NonNull
    public abstract AppDao appDao();


    @NonNull
    public static BrittleDatabase getInstance(@NonNull Context context) {
        if (instance == null) {
            synchronized (LOCK) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(), BrittleDatabase.class, DATABASE_NAME)
                            .fallbackToDestructiveMigration()
                            .build();
                }
            }
        }

        return instance;
    }


}

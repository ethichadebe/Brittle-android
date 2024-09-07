package com.brittle.brittle.database;


import static com.brittle.brittle.constants.AppConstants.G_ITEM_TABLE_NAME;

import androidx.annotation.NonNull;
import androidx.room.Dao;
import androidx.room.Insert;
import androidx.room.OnConflictStrategy;
import androidx.room.Query;
import androidx.room.Update;

import com.brittle.brittle.model.GroceryItem;


@Dao
public interface AppDao {

    /**
     * Save grocery Item to local database
     * @param groceryItem grocery Item
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void saveGroceryItem(@NonNull GroceryItem groceryItem);

    /**
     * Update Wifi token to local database
     * @param groceryItem grocery Item
     */
    @Update
    void updateGroceryItem(@NonNull GroceryItem groceryItem);

    /**
     * Return saved token.
     * @return Wifi token
     */
    @NonNull
    @Query("SELECT * FROM " + G_ITEM_TABLE_NAME)
    GroceryItem getGroceryItem();
}

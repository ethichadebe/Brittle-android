package com.brittle.brittle.model;


import static com.brittle.brittle.constants.AppConstants.G_ITEM_TABLE_NAME;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

import com.google.gson.annotations.Expose;

@Entity(tableName = G_ITEM_TABLE_NAME)
public class GroceryItem {

    @PrimaryKey(autoGenerate = true)
    @ColumnInfo(name = "gItemID")
    @Expose
    private int ItemID;
    @ColumnInfo(name = "gItemName")
    @Expose
    private String ItemName;
    @ColumnInfo(name = "gItemPrice")
    @Expose
    private double ItemPrice;
    @ColumnInfo(name = "gItemQuantity")
    @Expose
    private int ItemQuantity;
    @ColumnInfo(name = "gItemIsTicked")
    @Expose
    private int ItemIsTicked;

    public int getItemID() {
        return ItemID;
    }

    public void setItemID(int itemID) {
        ItemID = itemID;
    }

    public String getItemName() {
        return ItemName;
    }

    public void setItemName(String itemName) {
        ItemName = itemName;
    }

    public double getItemPrice() {
        return ItemPrice;
    }

    public void setItemPrice(double itemPrice) {
        ItemPrice = itemPrice;
    }

    public int getItemQuantity() {
        return ItemQuantity;
    }

    public void setItemQuantity(int itemQuantity) {
        ItemQuantity = itemQuantity;
    }

    public int getItemIsTicked() {
        return ItemIsTicked;
    }

    public void setItemIsTicked(int itemIsTicked) {
        ItemIsTicked = itemIsTicked;
    }

    public GroceryItem(String ItemName, double ItemPrice, int ItemQuantity, int ItemIsTicked) {
        this.ItemName = ItemName;
        this.ItemPrice = ItemPrice;
        this.ItemQuantity = ItemQuantity;
        this.ItemIsTicked = ItemIsTicked;
    }

    @Override
    public String toString() {
        return "GroceryItem{" +
                "Name = '" + ItemName + '\'' +
                ", Price = '" + ItemPrice + '\'' +
                ", Quantity = '" + ItemQuantity + '\'' + '}';
    }
}

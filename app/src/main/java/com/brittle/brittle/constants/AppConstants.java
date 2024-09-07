package com.brittle.brittle.constants;


import android.util.Log;

import androidx.annotation.NonNull;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.Socket;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Calendar;
import java.util.Date;
import java.util.Locale;
import java.util.Random;

import io.reactivex.rxjava3.android.schedulers.AndroidSchedulers;
import io.reactivex.rxjava3.core.Single;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class AppConstants {
    private static final String TAG = "AppConstants";
    public static final String BASE_URL = "https://wifihotspot.io/";
    public static final String G_ITEM_TABLE_NAME = "groceryItems";
    //ID      Quota


    public static Single<Boolean> hasInternetConnection() {
        return Single.fromCallable(() -> {
            try {
                // Connect to Google DNS to check for connection
                int timeoutMs = 1500;
                Socket socket = new Socket();
                InetSocketAddress socketAddress = new InetSocketAddress("8.8.8.8", 53);

                socket.connect(socketAddress, timeoutMs);
                socket.close();

                return true;
            } catch (IOException e) {
                return false;
            }
        }).subscribeOn(Schedulers.io()).observeOn(AndroidSchedulers.mainThread());
    }
}

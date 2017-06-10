package com.example.corsatk;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by bola on 6/7/2017.
 */

public class FireApp extends Application {
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
    }
}

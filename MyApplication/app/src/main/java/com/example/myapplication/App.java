package com.example.myapplication;

import android.app.Application;

import com.bumptech.glide.GlideBuilder;

public class App extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        GlideBuilder builder = new GlideBuilder();
        GlideApp.init(this, builder);
    }
}

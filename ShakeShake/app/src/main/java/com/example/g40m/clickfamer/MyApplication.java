package com.example.g40m.clickfamer;

import android.content.Context;

/**
 * Created by G40M on 2016/3/8.
 */
public class MyApplication extends android.app.Application {

    public static Context mContext;
    @Override
    public void onCreate()
    {
        super.onCreate();
        mContext = this;
    }
    public static Context getContext()
    {
        return mContext;
    }
}

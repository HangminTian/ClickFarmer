package com.example.g40m.clickfamer.SharedPerference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.g40m.clickfamer.MyApplication;

public class HallConfigManager {
    private static String CACHE_SHARE_P = "mycache_data";
    private static HallConfigManager mHallConfigManager;
    private static SharedPreferences mPreferences;

    public static HallConfigManager getInstance() {
        if (mHallConfigManager == null)
            mHallConfigManager = new HallConfigManager();
        return mHallConfigManager;
    }

    public HallConfigManager() {
        mPreferences = MyApplication.getContext().getSharedPreferences(CACHE_SHARE_P, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharePreferences() {
        if (mPreferences == null) {
            mPreferences = MyApplication.getContext().getSharedPreferences(CACHE_SHARE_P, Context.MODE_PRIVATE);
        }
        return mPreferences;
    }


}

package com.example.g40m.clickfamer.SharedPerference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.g40m.clickfamer.MyApplication;

import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

public class CacheManager {
    private static String CACHE_SHARE_P = "mycache_data";
    private static CacheManager mHallConfigManager;
    private static SharedPreferences mPreferences;

    private static String LOAD_TIME_KEY = "loadtime_key";
    private static String LOGINED_ACCOUNT_KEY = "logined_account_key";

    public static CacheManager getInstance() {
        if (mHallConfigManager == null)
            mHallConfigManager = new CacheManager();
        return mHallConfigManager;
    }

    public CacheManager() {
        mPreferences = MyApplication.getContext().getSharedPreferences(CACHE_SHARE_P, Context.MODE_PRIVATE);
    }

    public SharedPreferences getSharePreferences() {
        if (mPreferences == null) {
            mPreferences = MyApplication.getContext().getSharedPreferences(CACHE_SHARE_P, Context.MODE_PRIVATE);
        }
        return mPreferences;
    }

    public String getLastLoadTime() {
        return mPreferences.getString(LOAD_TIME_KEY, "");
    }

    public void setLastLoadTime(String nowTime) {
        mPreferences.edit().putString(LOAD_TIME_KEY, nowTime).commit();
    }

    public String getLoginedAccount() {
        return mPreferences.getString(LOGINED_ACCOUNT_KEY, "");
    }

    public void setLoginedAccount(String s) {
        mPreferences.edit().putString(LOGINED_ACCOUNT_KEY, s).commit();
    }

}

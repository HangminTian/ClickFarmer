package com.example.g40m.clickfamer.SharedPerference;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.g40m.clickfamer.MyApplication;

public class CacheHelper<T> {
    private static SharedPreferences sharePreferences;
    private static String CACHE_SHARE_P = "cache_data";
    private static CacheHelper helper = null;
    private static SharedPreferences.Editor editor;

    private  CacheHelper()
    {
        sharePreferences = MyApplication.getContext().getSharedPreferences(CACHE_SHARE_P, Context.MODE_PRIVATE);
        editor = sharePreferences.edit();
    }

    public static CacheHelper getCacheHelper()
    {
        if(helper==null)
            helper = new CacheHelper();
        return helper;
    }

    public void write(String s)
    {
        editor.putBoolean("silentMode", true);
        editor.putString("hello", s);
        editor.commit();
    }

    public String read()
    {
        boolean silent = sharePreferences.getBoolean("silentMode", false);
        String hello = sharePreferences.getString("hello", "Hi");
        return "silent = "+silent+" hello = "+hello;
    }


    public void remove(String key)
    {
        sharePreferences.edit().remove(key).apply();
    }
}

package com.example.g40m.clickfamer;

import android.app.Activity;
import android.os.Bundle;

import com.example.g40m.clickfamer.SharedPerference.HallConfigManager;

public class MainActivity extends Activity   {

    HallConfigManager manager = HallConfigManager.getInstance();
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initUI();

    }

    public  void initUI() {
        findViewById()
    }

    @Override
    protected void onPause() {
        super.onPause();
    }

    @Override
    protected void onResume() {
        super.onResume();

    }

    @Override
    protected void onStop() {
        super.onStop();
    }



}
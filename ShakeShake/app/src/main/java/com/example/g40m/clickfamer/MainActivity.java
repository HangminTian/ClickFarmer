package com.example.g40m.clickfamer;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.GridView;

import com.example.g40m.clickfamer.SharedPerference.CacheManager;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity   {

    CacheManager manager = CacheManager.getInstance();
    private GridView mGridView;
    private ItemAdapter mAdapter;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        checkTime();
        initUI();
    }

    private void checkTime(){
        if ((System.currentTimeMillis() - CacheManager.getInstance().getLastLoadTime()) > 1000 * 60 * 60 * 14){
            CacheManager.getInstance().setLoginedAccount("");
        }
        CacheManager.getInstance().setLastLoadTime();
    }

    private  void initUI() {
        findViewById(R.id.textview_import).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.setDatas(getDatas());
            }
        });

        findViewById(R.id.textview_reset).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mAdapter.setDatas(getInitDatas());
            }
        });

        mGridView = (GridView) findViewById(R.id.grideview_items);
        mAdapter = new ItemAdapter(this);
        mAdapter.setDatas(getInitDatas());
        mGridView.setAdapter(mAdapter);
        mGridView.setOnItemClickListener(mAdapter);

    }

    private List<Item> getInitDatas(){
        List<Item> list = new ArrayList<>();
        for(int i =0;i<20;i++)
            list.add(new Item("账号"+(i+1),""));
        return list;
    }

    private List<Item> getDatas(){
        List<Item> list = TxtUtil.GetSDKParam4UIFromFile("");
        return list;
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
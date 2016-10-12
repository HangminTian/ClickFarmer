package com.example.g40m.clickfamer;

import android.os.Environment;
import android.util.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by G40M on 2016/9/27.
 */
public class TxtUtil {
    public static List<Item> GetAccounts(){
        String lHalf = "shuatcy";
        return null;
    }
    public static List<Item> GetSDKParam4UIFromFile(String url)
    {
        List<Item> list = new ArrayList<>();
        if (url == null)
            return null;

        String strName = Environment.getExternalStorageDirectory()+"/"+ "data.txt";
        Log.d("thm","strName = "+strName);
        File f = new File(strName);
        if (f == null){
            Log.d("thm","strName  f == null");
            return null;
        }

        try {
            FileReader reader = new FileReader(f.getAbsolutePath());
            BufferedReader buf = new BufferedReader(reader);
            list = DeSerialize(buf);
            buf.close();
            reader.close();
        } catch (IOException e) {
            Log.d("thm","strName  error");
            e.printStackTrace();
        }
        return list;
    }

    public static List<Item> DeSerialize(BufferedReader buf) throws IOException {
        List<Item> list = new ArrayList<>();
        if (buf == null)
            return null;

        String line = null;
        while ((line = buf.readLine()) != null) {
            Log.d("thm","strName  line = "+line);
            String account="";
            String password="";
            account = line.trim();
//            String[] pList = line.split("=");
//            if (pList.length != 2)
//                continue;
//
//            if (pList[0].trim().compareTo("account") == 0){
//                account = pList[1].trim();
//                if((line = buf.readLine()) != null){
//                    pList = line.split("=");
//                    if (pList.length != 2)
//                        continue;
//                    if (pList[0].trim().compareTo("password") == 0){
//                        password = pList[1].trim();
                        list.add(new Item(account, "qawsed"));
//                    }
//
//                }
//            }
        }

        return list;
    }
}

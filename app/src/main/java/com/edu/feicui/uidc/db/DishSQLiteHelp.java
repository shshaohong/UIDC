package com.edu.feicui.uidc.db;

import android.content.Context;
import android.content.res.AssetManager;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.text.TextUtils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-12-30.
 */

public class DishSQLiteHelp extends SQLiteOpenHelper{

    private Context context;

    private List<String> datas = new ArrayList<>();

    public DishSQLiteHelp(Context context) {
        super(context, "dish_db.db", null, 1);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        datas = getSQL(context);
        for(int i = 0;i < datas.size();i++){
            String data = datas.get(i);
            if(!TextUtils.isEmpty(data)){
                System.out.println(data);
                sqLiteDatabase.execSQL(data);
            }
        }
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }

    public static List<String> getSQL(Context context){
        AssetManager assetManager = context.getAssets();
        List<String> list = new ArrayList<>();
        try {
            InputStream in = assetManager.open("db/dish_db.sql");
            BufferedReader br = new BufferedReader(new InputStreamReader(in));
            String data = null;

            while ((data = br.readLine()) != null){
                System.out.println(data);
                list.add(data);
            }

            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return list;
    }
}

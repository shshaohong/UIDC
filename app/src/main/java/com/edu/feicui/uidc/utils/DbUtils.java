package com.edu.feicui.uidc.utils;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.edu.feicui.uidc.entity.Dish;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-12-30.
 */

public class DbUtils {

    static SQLiteDatabase db = SQLiteDatabase.openOrCreateDatabase(
            "/data/data/com.edu.feicui.uidc/databases/dish_db.db", null);

    public static List<String> getDiskList(){
        List<String> diskList = new ArrayList<>();
        Cursor disk = db.query("table_list", null, null, null, null, null, null);

        while (disk.moveToNext()) {
            String num = disk.getString(disk.getColumnIndex("table_num"));
            diskList.add(num);
        }
        return diskList;
    }

    public static List<Dish> getALLDishList(){
        List<Dish> list = new ArrayList<>();

        Cursor cursor = db.query("dish_list", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Dish dish = new Dish();
            dish.setDishClass(cursor.getString(cursor.getColumnIndex("dish_class")));
            dish.setDishId(cursor.getString(cursor.getColumnIndex("dish_id")));
            dish.setDishName(cursor.getString(cursor.getColumnIndex("dish_name")));
            dish.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            dish.setIntroduction(cursor.getString(cursor.getColumnIndex("introduction")));
            dish.setImgPath(cursor.getString(cursor.getColumnIndex("img_path")));
            dish.setPrice(cursor.getString(cursor.getColumnIndex("price")));

            list.add(dish);
        }
        return list;
    }

    public static List<Dish> getDishList(int num){
        List<Dish> list = new ArrayList<>();
        List<String> typelist = new ArrayList<>();
        List<Dish> dishList = new ArrayList<>();

        Cursor cursor = db.query("dish_list", null, null, null, null, null, null);

        while (cursor.moveToNext()) {
            Dish dish = new Dish();
            dish.setDishClass(cursor.getString(cursor.getColumnIndex("dish_class")));
            dish.setDishId(cursor.getString(cursor.getColumnIndex("dish_id")));
            dish.setDishName(cursor.getString(cursor.getColumnIndex("dish_name")));
            dish.setPrice(cursor.getString(cursor.getColumnIndex("price")));
            dish.setIntroduction(cursor.getString(cursor.getColumnIndex("introduction")));
            dish.setImgPath(cursor.getString(cursor.getColumnIndex("img_path")));
            dish.setPrice(cursor.getString(cursor.getColumnIndex("price")));



            list.add(dish);
        }
        typelist = getDishTypeList();
        String key = typelist.get(num);
        for(int i = 0;i < list.size();i++){
            Dish dish = list.get(i);
            if(dish.getDishClass().equals(key)){
                dishList.add(dish);
            }
        }

        return dishList;
    }


    public static List<String> getDishTypeList(){
        List<String> list = new ArrayList<>();
        Cursor cursor = db.query("dish_list", null, null, null, null, null, null);

        while (cursor.moveToNext()) {

            String type = cursor.getString(cursor.getColumnIndex("dish_class"));
            if (list.size() == 0) {
                list.add("全部");
            }
            int s = 0;
            for (int i = 0; i < list.size(); i++) {
                if (!type.equals(list.get(i))) {
                    s++;
                }
            }

            if (s == list.size()) {
                list.add(type);
            }
        }

        return list;
    }

}

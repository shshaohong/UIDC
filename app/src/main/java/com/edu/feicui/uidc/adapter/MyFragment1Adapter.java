package com.edu.feicui.uidc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.feicui.uidc.fragment.LiangcaiFragment;
import com.edu.feicui.uidc.fragment.QitaFragment;
import com.edu.feicui.uidc.fragment.RecaiFragment;
import com.edu.feicui.uidc.fragment.TangleiFragment;
import com.edu.feicui.uidc.fragment.YinliaoFragment;

/**
 * Created by Administrator on 2017-1-9.
 */

public class MyFragment1Adapter extends FragmentPagerAdapter {

    public MyFragment1Adapter(FragmentManager fm) {
        super(fm);
    }

    @Override
    public Fragment getItem(int position) {
        switch(position) {
            case 0:
                return new RecaiFragment();
            case 1:
                return new LiangcaiFragment();
            case 2:
                return new TangleiFragment();
            case 3:
                return new YinliaoFragment();
            case 4:
                return new QitaFragment();
            default:
                throw new RuntimeException("未知错误");
        }
    }

    @Override
    public int getCount() {
        return 5;
    }
}

package com.edu.feicui.uidc.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.edu.feicui.uidc.fragment.CaipinFragment;
import com.edu.feicui.uidc.fragment.DingdanFragment;
import com.edu.feicui.uidc.fragment.GengduoFragment;
import com.edu.feicui.uidc.fragment.JiezhangFragment;
import com.edu.feicui.uidc.fragment.JinduFragment;

/**
 * Created by Administrator on 2017-1-7.
 */

public class MyFragmentAdapter extends FragmentPagerAdapter {


    public MyFragmentAdapter(FragmentManager fm) {
        super(fm);

    }

    @Override
    public Fragment getItem(int position) {
        switch (position) {
            case 0:
                return new CaipinFragment();
            case 1:
                return new JinduFragment();
            case 2:
                return new JiezhangFragment();
            case 3:
                return new GengduoFragment();
            case 4:
                return new DingdanFragment();
            case 5:
                return new DingdanFragment();
            case 6:
                return new DingdanFragment();

            default:
                throw new RuntimeException("未知错误");

        }

    }

    @Override
    public int getCount() {
        return 7;
    }
}

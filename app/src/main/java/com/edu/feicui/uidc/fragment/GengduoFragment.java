package com.edu.feicui.uidc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.entity.Dish;

/**
 * Created by Administrator on 2017-1-7.
 */

public class GengduoFragment extends Fragment {

    private Dish mDish;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gengduo, container, false);

        return view;
    }

//    @Override
//    public void onStart() {
//        super.onStart();
//        EventBus.getDefault().register(this);
//    }
//
//    @Override
//    public void onStop() {
//        super.onStop();
//        EventBus.getDefault().unregister(this);
//    }

//    @Subscribe(threadMode = ThreadMode.MAIN)
//    private void fromAdapter(MessageEvent event) {
//
//        switch (event.getType()){
//            case MessageEvent.TYPE_A:
//                mDish = event.getDish();
//
//                break;
//        }
//    }
}

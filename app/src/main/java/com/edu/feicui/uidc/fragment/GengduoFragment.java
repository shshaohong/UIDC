package com.edu.feicui.uidc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.Toast;

import com.edu.feicui.uidc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-1-7.
 */

public class GengduoFragment extends Fragment {

    @BindView(R.id.btn_chaxun)
    Button btnChaxun;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_gengduo, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_chaxun)
    public void setBtnChaxun() {
        Toast.makeText(getContext(), "查询失败，请稍后再试", Toast.LENGTH_SHORT).show();
    }
}

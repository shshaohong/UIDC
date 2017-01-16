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
 * Created by Administrator on 2017-1-9.
 */

public class DingdanFragment extends Fragment {

    @BindView(R.id.btn_tijiaodingdan)
    Button btnTijiao;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {


        View view = inflater.inflate(R.layout.fragment_dingdan, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_tijiaodingdan)
    public void setBtnTijiao() {
        Toast.makeText(getContext(), "提交成功", Toast.LENGTH_SHORT).show();
    }

}

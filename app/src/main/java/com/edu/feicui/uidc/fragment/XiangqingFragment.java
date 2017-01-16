package com.edu.feicui.uidc.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.Toast;

import com.edu.feicui.uidc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-1-15.
 */

public class XiangqingFragment extends DialogFragment {

    @BindView(R.id.btn_xiangqing)
    Button btnXiang;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        View view = inflater.inflate(R.layout.fragment_xiangqing, container, false);
        ButterKnife.bind(this, view);
        return view;
    }
    @OnClick(R.id.btn_xiangqing)
    public void onbtn(){
        Toast.makeText(getActivity(), "添加成功", Toast.LENGTH_SHORT).show();
    }
}

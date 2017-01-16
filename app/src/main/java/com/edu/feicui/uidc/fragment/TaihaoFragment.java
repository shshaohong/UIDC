package com.edu.feicui.uidc.fragment;

import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.text.TextUtils;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.entity.MessageEvent;

import org.greenrobot.eventbus.EventBus;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-1-16.
 */

public class TaihaoFragment extends DialogFragment {
    @BindView(R.id.et_renshu)
    EditText mEtRenshu;
    @BindView(R.id.btn_renshu)
    Button mBtnRenshu;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        getDialog().requestWindowFeature(Window.FEATURE_NO_TITLE);
        getDialog().getWindow().setBackgroundDrawable(new ColorDrawable(Color.YELLOW));
        View view = inflater.inflate(R.layout.fragment_taihao, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.btn_renshu)
    public void setEtRenshu() {
        String num = mEtRenshu.getText().toString();
        if (TextUtils.isEmpty(num)) {
            Toast.makeText(getContext(), "人数不能为空", Toast.LENGTH_SHORT).show();
            return;
        }

        MessageEvent event = new MessageEvent();
        event.setType(MessageEvent.TYPE_B);
        event.setNum(num);
        EventBus.getDefault().post(event);

        getDialog().cancel();
    }
}

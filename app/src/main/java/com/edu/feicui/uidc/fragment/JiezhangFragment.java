package com.edu.feicui.uidc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import com.edu.feicui.uidc.R;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2017-1-7.
 */

public class JiezhangFragment extends Fragment {

    @BindView(R.id.iv_baidu_zhifu)
    ImageView baidu;
    @BindView(R.id.iv_weixin_zhifu)
    ImageView weixin;
    @BindView(R.id.iv_zhifubao_zhifu)
    ImageView zhifubao;
    private AlipayFragment mAlipayFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_jiezhang, container, false);

        ButterKnife.bind(this, view);
        return view;
    }

    @OnClick(R.id.iv_weixin_zhifu)
    public void onWeixin() {
        if (mAlipayFragment == null) {
            mAlipayFragment = new AlipayFragment();

        }
        mAlipayFragment.show(getFragmentManager(),"bc");
    }

    @OnClick(R.id.iv_baidu_zhifu)
    public void onbaidu() {
        Toast.makeText(getContext(), "暂未开通百度支付", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.iv_zhifubao_zhifu)
    public void onzhifubao() {
        Toast.makeText(getContext(), "暂未开通支付宝支付", Toast.LENGTH_SHORT).show();
    }
}

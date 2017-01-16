package com.edu.feicui.uidc.activity;

import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.adapter.MyFragment1Adapter;
import com.edu.feicui.uidc.adapter.MyFragmentAdapter;
import com.edu.feicui.uidc.entity.MessageEvent;
import com.edu.feicui.uidc.fragment.OutFragment;
import com.edu.feicui.uidc.fragment.RenshuFragment;
import com.edu.feicui.uidc.fragment.TaihaoFragment;

import org.greenrobot.eventbus.EventBus;
import org.greenrobot.eventbus.Subscribe;
import org.greenrobot.eventbus.ThreadMode;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2016-12-28.
 */

public class HomeActivity extends FragmentActivity {


    @BindView(R.id.viewPager)
    ViewPager mViewPager;
    @BindView(R.id.viewPager2)
    ViewPager mViewPager2;

    //菜类
    @BindView(R.id.ll_recai)
    LinearLayout llRecai;
    @BindView(R.id.ll_liangcai)
    LinearLayout llLiangcai;
    @BindView(R.id.ll_tanglei)
    LinearLayout llTanglei;

    @BindView(R.id.ll_yinliao)
    LinearLayout llYinliao;
    @BindView(R.id.ll_qita)
    LinearLayout llQita;

    //左边功能栏
    @BindView(R.id.ll_caipin)
    LinearLayout llCaipin;
    @BindView(R.id.ll_jindu)
    LinearLayout llJindu;
    @BindView(R.id.ll_jiezhang)
    LinearLayout llJiezhang;
    @BindView(R.id.ll_gengduo)
    LinearLayout llGengduo;
    @BindView(R.id.ll_dingdan)
    LinearLayout llDingdan;

    //菜单栏与功能栏的显示与隐藏
    @BindView(R.id.ll_dish_show)
    LinearLayout llDishShow;
    @BindView(R.id.ll_gengduo_show)
    LinearLayout llGengduoShow;

    @BindView(R.id.tv_gengduo_chakan)
    TextView tvChakan;

    @BindView(R.id.tai_hao)
    TextView tvTaihao;
    @BindView(R.id.ren_shu)
    TextView tvRenshu;

    private MyFragmentAdapter mAdapter2;
    private MyFragment1Adapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        ButterKnife.bind(this);
        initView();

    }

    //初始化
    private void initView() {

        mAdapter2 = new MyFragmentAdapter(getSupportFragmentManager());
        adapter = new MyFragment1Adapter(getSupportFragmentManager());

        //菜类的fragment
        mViewPager.setAdapter(adapter);
        mViewPager.addOnPageChangeListener(listener);
        llRecai.setSelected(true);


        //功能类的fragment
        mViewPager2.setAdapter(mAdapter2);
        mViewPager2.addOnPageChangeListener(listener2);
    }

    //菜栏的监听
    private ViewPager.OnPageChangeListener listener = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            llRecai.setSelected(position == 0);
            llLiangcai.setSelected(position == 1);
            llTanglei.setSelected(position == 2);
            llYinliao.setSelected(position == 3);
            llQita.setSelected(position == 4);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };
    //功能栏的监听
    private ViewPager.OnPageChangeListener listener2 = new ViewPager.OnPageChangeListener() {
        @Override
        public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

        }

        @Override
        public void onPageSelected(int position) {
            llCaipin.setSelected(position == 0);
            llJindu.setSelected(position == 1);
            llJiezhang.setSelected(position == 2);
            llGengduo.setSelected(position == 3);
//            tvHuantai.setSelected(position == 4);
//            tvShuju.setSelected(position == 5);
            llDingdan.setSelected(position == 4);
        }

        @Override
        public void onPageScrollStateChanged(int state) {

        }
    };

    //热菜，凉菜，饮料，其他，汤类点击事件
    @OnClick({R.id.ll_recai, R.id.ll_liangcai, R.id.ll_tanglei,
            R.id.ll_yinliao, R.id.ll_qita})
    public void onClick(LinearLayout layout) {

        switch (layout.getId()) {
            case R.id.ll_recai:
                setSelectedFormGongneng();
                llRecai.setSelected(true);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager2.setVisibility(View.GONE);
                mViewPager.setCurrentItem(0);
                break;
            case R.id.ll_liangcai:
                setSelectedFormGongneng();
                llLiangcai.setSelected(true);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager2.setVisibility(View.GONE);
                mViewPager.setCurrentItem(1);
                break;
            case R.id.ll_tanglei:
                setSelectedFormGongneng();
                llTanglei.setSelected(true);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager2.setVisibility(View.GONE);
                mViewPager.setCurrentItem(2);
                break;
            case R.id.ll_yinliao:
                setSelectedFormGongneng();
                llYinliao.setSelected(true);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager2.setVisibility(View.GONE);
                mViewPager.setCurrentItem(3);
                break;
            case R.id.ll_qita:
                setSelectedFormGongneng();
                llQita.setSelected(true);
                mViewPager.setVisibility(View.VISIBLE);
                mViewPager2.setVisibility(View.GONE);
                mViewPager.setCurrentItem(4);
                break;

            default:
                throw new RuntimeException("未知错误");
        }

    }

    //左边功能栏的点击事件
    @OnClick({R.id.ll_caipin, R.id.ll_jindu, R.id.ll_jiezhang,
            R.id.ll_gengduo, R.id.ll_dingdan,
            //R.id.tv_gengduo_huantai,R.id.tv_gengduo_shujugengxin

    })
    public void onClickGongneng(LinearLayout layout) {

        switch (layout.getId()) {
            case R.id.ll_caipin:
                showDish();
                setSelectedFormDish();
                llCaipin.setSelected(true);
                mViewPager.setVisibility(View.GONE);
                mViewPager2.setVisibility(View.VISIBLE);
                mViewPager2.setCurrentItem(0, false);
                break;
            case R.id.ll_jindu:
                hideGandD();
                setSelectedFormDish();
                llJindu.setSelected(true);
                mViewPager.setVisibility(View.GONE);
                mViewPager2.setVisibility(View.VISIBLE);
                mViewPager2.setCurrentItem(1, false);
                break;
            case R.id.ll_jiezhang:
                hideGandD();
                setSelectedFormDish();
                llJiezhang.setSelected(true);
                mViewPager.setVisibility(View.GONE);
                mViewPager2.setVisibility(View.VISIBLE);
                mViewPager2.setCurrentItem(2, false);
                break;
            case R.id.ll_gengduo:
                showGengduo();
                tvChakan.setSelected(true);
                setSelectedFormDish();
                llGengduo.setSelected(true);
                mViewPager.setVisibility(View.GONE);
                mViewPager2.setVisibility(View.VISIBLE);
                mViewPager2.setCurrentItem(3, false);
                break;
//            case R.id.tv_gengduo_huantai:
//                llGengduo.setSelected(true);
//                tvHuantai.setSelected(true);
//                tvChakan.setSelected(false);
//                tvShuju.setSelected(false);
//                mViewPager2.setCurrentItem(4,false);
//                break;
//            case R.id.tv_gengduo_shujugengxin:
//                llGengduo.setSelected(true);
//                tvHuantai.setSelected(false);
//                tvChakan.setSelected(false);
//                tvShuju.setSelected(true);
//                mViewPager2.setCurrentItem(5,false);
//                break;

            case R.id.ll_dingdan:
                hideGandD();
                setSelectedFormDish();
                llDingdan.setSelected(true);
                mViewPager.setVisibility(View.GONE);
                mViewPager2.setVisibility(View.VISIBLE);
                mViewPager2.setCurrentItem(6, false);
                break;
        }

    }

    private void hideGandD(){
        llGengduoShow.setVisibility(View.INVISIBLE);
        llDishShow.setVisibility(View.GONE);
    }

    private void showGengduo(){

        llDishShow.setVisibility(View.GONE);
        llGengduoShow.setVisibility(View.VISIBLE);
    }
    private void showDish(){
        llDishShow.setVisibility(View.VISIBLE);
        llGengduoShow.setVisibility(View.GONE);
    }

    //点击功能栏的时候把菜的按钮设置成白色
    private void setSelectedFormDish() {
        llRecai.setSelected(false);
        llLiangcai.setSelected(false);
        llTanglei.setSelected(false);
        llYinliao.setSelected(false);
        llQita.setSelected(false);
    }

    //点击菜的时候功能栏按钮设置成白色
    private void setSelectedFormGongneng() {
        llCaipin.setSelected(false);
        llJindu.setSelected(false);
        llJiezhang.setSelected(false);
        llGengduo.setSelected(false);
        llDingdan.setSelected(false);
    }

    @OnClick(R.id.ll_fuwu)
    public void onClickFuwu(){
        Toast.makeText(this, "美女服务员正在过来，稍等一下哦亲！", Toast.LENGTH_SHORT).show();
    }
    private OutFragment mOutFragment;
    @OnClick(R.id.shezhi)
    public void onSheshi(){

        if (mOutFragment == null) {
            mOutFragment = new OutFragment();
        }
        mOutFragment.show(getSupportFragmentManager(),"aa");
    }

    @OnClick(R.id.tv_gengduo_huantai)
    public void onhuantai() {
        Toast.makeText(this, "获取数据失败，请稍后再试", Toast.LENGTH_SHORT).show();
    }
    @OnClick(R.id.tv_gengduo_shujugengxin)
    public void onshuju() {
        Toast.makeText(this, "获取数据失败，请稍后再试", Toast.LENGTH_SHORT).show();
    }

    private RenshuFragment renshuFragment;
    private TaihaoFragment taihaoFragment;
    @OnClick(R.id.tai_hao)
    public void setTvTaihao() {
        if (renshuFragment == null) {
            renshuFragment = new RenshuFragment();
        }
        renshuFragment.show(getSupportFragmentManager(),"ren");
    }

    @OnClick(R.id.ren_shu)
    public void setTvRenshu() {
        if (taihaoFragment == null) {
            taihaoFragment = new TaihaoFragment();
        }
        taihaoFragment.show(getSupportFragmentManager(),"ren");
    }



    @Subscribe(threadMode = ThreadMode.MAIN)
    public void setRenshu(MessageEvent event) {
        switch (event.getType()) {
            case MessageEvent.TYPE_A:
                String num = event.getNum();
                tvTaihao.setText(num);
                break;
            case MessageEvent.TYPE_B:
                String num1 = event.getNum();
                tvRenshu.setText(num1);
                break;
        }

    }

    @Override
    protected void onStart() {
        super.onStart();
        EventBus.getDefault().register(this);
    }

    @Override
    protected void onStop() {
        super.onStop();
        EventBus.getDefault().unregister(this);
    }
}


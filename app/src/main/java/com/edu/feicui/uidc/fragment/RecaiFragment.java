package com.edu.feicui.uidc.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.adapter.DishAdapter;
import com.edu.feicui.uidc.entity.Dish;
import com.edu.feicui.uidc.utils.DbUtils;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2016-12-29.
 */

public class RecaiFragment extends Fragment{

    @BindView(R.id.rl_dish_recai)
    RecyclerView mRecyclerView;

    private DishAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View view;

    private XiangqingFragment mXiangqingFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        if(view == null){
            view= inflater.inflate(R.layout.fragment_recai,container,false);
        }
        ButterKnife.bind(this,view);

        final List<Dish> list = DbUtils.getDishList(1);

        mAdapter = new DishAdapter(getContext());

        mLayoutManager = new GridLayoutManager(getContext(),3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mRecyclerView.setAdapter(mAdapter);
        mAdapter.addList(list,true);
        mAdapter.notifyDataSetChanged();

        mAdapter.setOnItemClickListener(new DishAdapter.OnRecyclerViewItemClickListener() {
            @Override
            public void onItemClickListener(View view, int data) {
                if (mXiangqingFragment == null) {
                    mXiangqingFragment = new XiangqingFragment();
                }
                mXiangqingFragment.show(getFragmentManager(),"aaa");
            }


        });

        return view;
    }


}

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
 * Created by Administrator on 2017-1-7.
 */

public class CaipinFragment extends Fragment {

    @BindView(R.id.rl_caipin)
    RecyclerView mRecyclerView;

    private RecyclerView.LayoutManager mLayoutManager;
    private DishAdapter mAdapter;


    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_caipin, container, false);
        ButterKnife.bind(this, view);
        List<Dish> list = DbUtils.getALLDishList();

        mLayoutManager = new GridLayoutManager(getContext(), 3);
        mRecyclerView.setLayoutManager(mLayoutManager);

        mAdapter = new DishAdapter(getActivity());
        mRecyclerView.setAdapter(mAdapter);

        mAdapter.addList(list,true);
        mAdapter.notifyDataSetChanged();

        return view;
    }
}

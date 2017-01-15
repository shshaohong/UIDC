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

public class TangleiFragment extends Fragment {

    @BindView(R.id.rl_dish_tanglei)
    RecyclerView mRecyclerView;

    private DishAdapter adapter;
    private RecyclerView.LayoutManager mManager;
    private XiangqingFragment mXiangqingFragment;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_tanglei, container, false);
        ButterKnife.bind(this, view);

        List<Dish> list = DbUtils.getDishList(3);
        adapter = new DishAdapter(getContext());
        mManager = new GridLayoutManager(getContext(), 3);

        mRecyclerView.setAdapter(adapter);
        mRecyclerView.setLayoutManager(mManager);
        adapter.addList(list, true);
        adapter.notifyDataSetChanged();
        adapter.setOnItemClickListener(new DishAdapter.OnRecyclerViewItemClickListener() {
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

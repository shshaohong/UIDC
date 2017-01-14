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

public class RecaiFragment extends Fragment {

    @BindView(R.id.rl_dish_recai)
    RecyclerView mRecyclerView;

    private DishAdapter mAdapter;
    private RecyclerView.LayoutManager mLayoutManager;
    private View view;



//    private int[] imageIcon = {
//        R.drawable.recai1,R.drawable.recai2,R.drawable.recai3,R.drawable.recai4,R.drawable.recai5,
//            R.drawable.recai6,R.drawable.recai7,R.drawable.recai8,R.drawable.recai9,R.drawable.recai10,
//            R.drawable.recai11,R.drawable.recai12
//    };
//    private String[] dishName = {
//          "辣炒什锦藕丁","私房东坡肉","红烧排骨","宫保鸡丁","肉末茄子粉丝煲",
//            "麻婆豆腐","辣炒什锦藕丁","辣炒什锦藕丁","辣炒什锦藕丁",
//            "辣炒什锦藕丁","辣炒什锦藕丁","辣炒什锦藕丁"
//    };
//    private String[] num = {
//      "58/份","85/份","62/份","52/份","42/份","38/份","85/份","85/份","85/份","85/份","85/份","85/份"
//    };
//    private List<Map<String, Object>> mList;


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
                final Dish dish = list.get(data);
//                if(dish.isChoose()){
//                    dish.setChoose(false);
//                    mAdapter.notifyDataSetChanged();
//                }else{
//                    dish.setChoose(true);
//                    mAdapter.notifyDataSetChanged();
//                }

            }

            @Override
            public void onItemViewClickListener(View view, int data) {
//                view.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        view.setOnClickListener(new View.OnClickListener() {
//                            @Override
//                            public void onClick(View view) {
//                                Toast.makeText(getContext(), "点击了图片", Toast.LENGTH_SHORT).show();
//                            }
//                        });
//
//                    }
//                });
            }
        });

//                textView.setSelected(true);
//                textView.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View view) {
//                        EventBus.getDefault().post(dish);
//                    }
//                });
        return view;
    }

//
//    @Override
//    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
//        super.onViewCreated(view, savedInstanceState);
//


//        mSimpleAdapter = new SimpleAdapter(getContext(),getData(),R.layout.fragmeng_list_item,
//                new String[]{"icon","dishName","num"},
//                new int[]{R.id.iv_icon,R.id.tv_dish_name,R.id.tv_dish_num});

//
//
//    }
//    private List<Map<String,Object>> getData(){
//        mList = new ArrayList<>();
//        Map<String,Object> map = new HashMap<>();
//        for (int i = 0; i < imageIcon.length; i++) {
//            map.put("icon",imageIcon[i]);
//            map.put("dishName",dishName[i]);
//            map.put("num", num[i]);
//            mList.add(map);
//        }
//        return mList;
//    }
}

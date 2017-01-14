package com.edu.feicui.uidc.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.edu.feicui.uidc.R;
import com.edu.feicui.uidc.entity.Dish;
import com.edu.feicui.uidc.entity.MessageEvent;
import com.edu.feicui.uidc.url.Url;
import com.squareup.picasso.Picasso;

import org.greenrobot.eventbus.EventBus;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2016-12-30.
 */

public class DishAdapter extends RecyclerView.Adapter<DishAdapter.myViewHolder> {

    private Context mContext;
    private LayoutInflater inflater;
    private List<Dish> mList;
    private OnRecyclerViewItemClickListener mOnRecyclerViewItemClickListener;

    public DishAdapter(Context context) {
        mList = new ArrayList<>();
        this.mContext = context;
        inflater = LayoutInflater.from(context);
    }

    public void addList(List<Dish> data, boolean isClear) {
        if (data == null || data.size() == 0) {
            return;
        }
        if (isClear) {
            mList.clear();
        }
        mList.addAll(data);
    }

    @Override
    public myViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = inflater.inflate(R.layout.fragmeng_list_item, parent, false);
        myViewHolder holder = new myViewHolder(view);
        return holder;
    }

    @Override
    public void onBindViewHolder(final myViewHolder holder, int position) {
        final Dish dishEntity = mList.get(position);

        holder.tvNum.setText(dishEntity.getPrice());
        holder.tvName.setText(dishEntity.getDishName());

        Picasso.with(mContext).load(Url.BASE_URL + dishEntity.getImgPath()).into(holder.ivIcon);
        Log.e("aaa", dishEntity.getImgPath());
        holder.BtnAddDish.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                MessageEvent event = new MessageEvent();
                event.setType(MessageEvent.TYPE_A);
                event.setDish(dishEntity);
                EventBus.getDefault().post(event);
                holder.BtnAddDish.setSelected(true);
            }
        });
    }

    @Override
    public int getItemCount() {
        return mList.size();
    }

    public void setOnItemClickListener(
            OnRecyclerViewItemClickListener listener) {
        this.mOnRecyclerViewItemClickListener = listener;
    }

    public interface OnRecyclerViewItemClickListener {

        void onItemClickListener(View view, int data);

        void onItemViewClickListener(View view, int data);

    }

    class myViewHolder extends RecyclerView.ViewHolder {

        ImageView ivIcon;
        TextView tvName;
        TextView tvNum;
        TextView BtnAddDish;

        public myViewHolder(View itemView) {
            super(itemView);
            ivIcon = (ImageView) itemView.findViewById(R.id.iv_icon);
            tvName = (TextView) itemView.findViewById(R.id.tv_dish_name);
            tvNum = (TextView) itemView.findViewById(R.id.tv_dish_num);
            BtnAddDish = (TextView) itemView.findViewById(R.id.tv_jiacai);


        }
    }

}

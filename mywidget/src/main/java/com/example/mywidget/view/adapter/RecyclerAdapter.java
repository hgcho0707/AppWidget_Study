package com.example.mywidget.view.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywidget.R;

import java.util.ArrayList;

import kr.co.hdtel.core.model.Carbon;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    //  Nullable, NonNull, NonNull annotation 검색
    @NonNull
    private final ArrayList<Carbon> mRecyclerItems;

    public RecyclerAdapter(@NonNull ArrayList < Carbon > recyclerItemList) {
        mRecyclerItems = recyclerItemList; //생성자 constructor
    }

    @NonNull
    @Override
    public RecyclerViewHolder onCreateViewHolder (ViewGroup parent,int viewType){

        // 사용할 아이템의 뷰를 생성
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.carbon_recycler_items, parent, false);

        return new RecyclerViewHolder(view);
    }


    @Override
    public void onBindViewHolder (RecyclerViewHolder holder,int position){
        Carbon items = mRecyclerItems.get(position);

        holder.mTvCarbonUsage.setText(items.getmUsageText());
        holder.mTvCarbonCarbon.setText(items.getCarbonText());
        holder.mTvCarbonTitle.setText(items.getHeadText());

    }

    @Override
    public int getItemCount () {
        return mRecyclerItems.size();

    }

    // ViewHolder를 InnerClass로
    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {

        public TextView mTvCarbonTitle;
        public TextView mTvCarbonUsage;
        public TextView mTvCarbonCarbon;

        public RecyclerViewHolder(View itemView) {
            super(itemView);

            mTvCarbonTitle = itemView.findViewById(R.id.tv_carbon_recylcer_item_title);
            mTvCarbonUsage = itemView.findViewById(R.id.tv_carbon_recylcer_item_usage);
            mTvCarbonCarbon = itemView.findViewById(R.id.tv_carbon_recylcer_item_carbon);

        }
    }
}

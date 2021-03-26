package com.example.mywidget.view;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ProgressBar;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.mywidget.R;

import kr.co.hdtel.core.utils.Utils;

public class ElectroFragment extends Fragment {

    private ProgressBar mProgressBar;
    Context mContext;

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup)inflater.inflate(R.layout.fragment_electro, container, false);
        mContext = getContext();

        String month_usage = Utils.randomData(200, 1000);
        String usage_fee = Utils.randomFee(50000, 200000);
        String target_value = Utils.randomData(600, 900);
        String usage_rate = Utils.usageRate(Double.parseDouble(target_value), Double.parseDouble(month_usage));
        int progress = Integer.parseInt(usage_rate);

        mProgressBar = root.findViewById(R.id.pb_electro_usage_rate);

        Handler progressBarHandler = new Handler();
        progressBarHandler.post(new Runnable() {
            public void run() {
                mProgressBar.setProgress(progress);
            }
        });

        TextView mTvMonthUsage = root.findViewById(R.id.tv_electro_month_accum_usage_data);
        mTvMonthUsage.setText(month_usage);

        TextView mTvUsageFee = root.findViewById(R.id.tv_electro_accum_usage_fee_data);
        mTvUsageFee.setText(usage_fee);

        TextView mTvUsageRate = root.findViewById(R.id.tv_energy_usage_rate_data);
        if(Double.parseDouble(usage_rate) < 100){
            mTvUsageRate.setTextColor(Color.parseColor("#23a696"));
        }else{
            mTvUsageRate.setTextColor(Color.parseColor("#f26120"));
        }
        mTvUsageRate.setText(usage_rate);

        TextView mTvTargetValue = root.findViewById(R.id.tv_energy_target_value_data);
        mTvTargetValue.setText(target_value);

        return root;
    }


}
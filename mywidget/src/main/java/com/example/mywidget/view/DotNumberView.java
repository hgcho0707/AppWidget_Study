package com.example.mywidget.view;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;

import com.example.mywidget.R;

public class DotNumberView extends LinearLayout {
    private static final String RESOURSE_ID = "common_fnt_txt_";
    private static final String RESOURSE_ID_BLACK_END = "_bk";
    private static final String RESOURSE_ID_RED_END = "_rd";

    private Context mContext;

    private View mView;

    public DotNumberView(Context context) {
        super(context);
        initView(context);
    }

    public DotNumberView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public DotNumberView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    private void initView(Context context) {
        mContext = context;
        String infService = Context.LAYOUT_INFLATER_SERVICE;
        LayoutInflater li = (LayoutInflater) getContext().getSystemService(infService);
        if (li != null) {
            mView = li.inflate(R.layout.layout_dot_number_view, this, false);
            addView(mView);
        }
    }

    public void setNumber(int value) {
        int thousand = value / 1000;
        int hundred = value % 1000 / 100;
        int ten = value % 1000 % 100 / 10;
        int one = value % 1000 % 100 % 10;

        //Log.e("확인", "천 : " + thousand + " 백 : " + hundred + " 십 : " + ten + " 일 : " + one);
        if (value > 9999) {
            thousand = hundred = ten = one = 9;
        }

        // 기본 텍스트 컬러 -> BLACK
        String strEnd = RESOURSE_ID_BLACK_END;

        // 값이 2000이 넘으면 텍스트 컬러 -> RED
        if (value > 2000) {
            strEnd = RESOURSE_ID_RED_END;
        }

        if (thousand > 0) {
            String resourceName = RESOURSE_ID + thousand + strEnd;
            // 이해부족
            int id = mContext.getResources().getIdentifier(resourceName, "drawable", mContext.getPackageName());
            mView.findViewById(R.id.thousand_num).setVisibility(VISIBLE);
            mView.findViewById(R.id.thousand_num).setBackgroundResource(id);
        } else {
            mView.findViewById(R.id.thousand_num).setVisibility(GONE);
        }

        if (thousand == 0 && hundred == 0) {
            mView.findViewById(R.id.hundred_num).setVisibility(GONE);
        } else {
            String resourceName = RESOURSE_ID + hundred + strEnd;
            int id = mContext.getResources().getIdentifier(resourceName, "drawable", mContext.getPackageName());
            mView.findViewById(R.id.hundred_num).setVisibility(VISIBLE);
            mView.findViewById(R.id.hundred_num).setBackgroundResource(id);
        }

        if (thousand == 0 && hundred == 0 && ten == 0) {
            mView.findViewById(R.id.ten_num).setVisibility(GONE);
        } else {
            String resourceName = RESOURSE_ID + ten + strEnd;
            int id = mContext.getResources().getIdentifier(resourceName, "drawable", mContext.getPackageName());
            mView.findViewById(R.id.ten_num).setVisibility(VISIBLE);
            mView.findViewById(R.id.ten_num).setBackgroundResource(id);
        }

        String resourceName = RESOURSE_ID + one + strEnd;
        int id = mContext.getResources().getIdentifier(resourceName, "drawable", mContext.getPackageName());
        mView.findViewById(R.id.one_num).setBackgroundResource(id);

    }

    public void setError() {

        mView.findViewById(R.id.thousand_num).setVisibility(GONE);

        mView.findViewById(R.id.hundred_num).setVisibility(GONE);

        mView.findViewById(R.id.ten_num).setVisibility(GONE);

        mView.findViewById(R.id.one_num).setBackgroundResource(R.drawable.comm_toggle_display_count_minus);

    }
}

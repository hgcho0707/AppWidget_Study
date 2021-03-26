package com.example.mywidget.view;

import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mywidget.R;
import com.example.mywidget.view.adapter.RecyclerAdapter;

import java.util.ArrayList;

import kr.co.hdtel.core.model.Carbon;
import kr.co.hdtel.core.utils.Utils;

public class CarbonFragment extends Fragment {

    static final int COUNT_THREE = 3;
    static final int COUNT_FOUR = 4;
    static final int COUNT_FIVE = 5;
    static final int COUNT_SIX = 6;

    private final String[] mHeadName = {"전기", "가스", "수도", "온수", "난방", "냉방"};

    @SuppressLint("SetTextI18n")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_carbon, container, false);

        TextView mTvCarbon = root.findViewById(R.id.tv_carbon_co2_emissions);
        TextView mTvTree = root.findViewById(R.id.tv_carbon_tree_count);

        mTvCarbon.setText(Utils.randomData(50, 500) + "kg");
        mTvTree.setText(Utils.randomData(1, 15) + "그루");

        RecyclerView mRecyclerView = root.findViewById(R.id.recyclerview);
        ArrayList<Carbon>  mData = new ArrayList<>();

        int i = 0;
        while (i < COUNT_FOUR) {
            mData.add(new Carbon(mHeadName[i], Utils.randomData(5, 100), Utils.randomData(100, 3000)));
            i++;

        }
        if (i == COUNT_THREE) {
            mRecyclerView.addItemDecoration(new RecyclerDecoration(226));
        } else if (i == COUNT_FOUR) {
            mRecyclerView.addItemDecoration(new RecyclerDecoration(134));
        } else if (i == COUNT_FIVE) {
            mRecyclerView.addItemDecoration(new RecyclerDecoration(87));
        } else if (i == COUNT_SIX) {
            mRecyclerView.addItemDecoration(new RecyclerDecoration(52));
        }

        //그리드레이아웃 매니저로
        GridLayoutManager mGridLayoutManager = new GridLayoutManager(getContext(), 1);
        mGridLayoutManager.setOrientation(GridLayoutManager.HORIZONTAL);
        mRecyclerView.setLayoutManager(mGridLayoutManager);

        RecyclerAdapter mRecyclerAdapter = new RecyclerAdapter(mData);
        // 어댑터에 붙힘
        mRecyclerView.setAdapter(mRecyclerAdapter);

        return root;
    }

    public static class RecyclerDecoration extends RecyclerView.ItemDecoration {
        private final int mDivWidth;

        public RecyclerDecoration(int divWidth) {
            this.mDivWidth = divWidth;
        }

        @Override
        public void getItemOffsets(@NonNull Rect outRect, @NonNull View view, @NonNull RecyclerView parent, @NonNull RecyclerView.State state) {
            outRect.right = mDivWidth;
        }
    }
}
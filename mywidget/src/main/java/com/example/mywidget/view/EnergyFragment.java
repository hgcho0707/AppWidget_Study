package com.example.mywidget.view;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.viewpager.widget.ViewPager;

import com.example.mywidget.R;
import com.example.mywidget.view.adapter.EnergyPagerAdapter;
import com.google.android.material.tabs.TabLayout;

public class EnergyFragment extends Fragment {

    private ViewPager mViewPager;
    private EnergyPagerAdapter mEnergyPagerAdapter;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        ViewGroup root = (ViewGroup) inflater.inflate(R.layout.fragment_energy, container, false);

        mViewPager = root.findViewById(R.id.vp_energy);

        assert getFragmentManager() != null;
        mEnergyPagerAdapter = new EnergyPagerAdapter(getFragmentManager());

        TabLayout tabLayout = root.findViewById(R.id.tablayout_energy);
        tabLayout.addTab(tabLayout.newTab().setText("전기"));
        tabLayout.addTab(tabLayout.newTab().setText("가스"));
        tabLayout.addTab(tabLayout.newTab().setText("수도"));

        mViewPager.setAdapter(mEnergyPagerAdapter);
        mViewPager.setOffscreenPageLimit(mEnergyPagerAdapter.mFragments.size());

        // Pager가 변경될 때 발생하는 이벤트로 이 때, TabLayout의 탭까지 변경해주어야 함. 이 동작 처리하지 않을 시 Pager는 슬라이딩되어도 탭은 움직이지 않음
        mViewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        // 반대로 tab이 눌렸을 시 Pager가 같이 변경되게 처리
        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {

            @Override
            // 탭이 선택될 때 발생하는 이벤트
            public void onTabSelected(TabLayout.Tab tab) {
                mViewPager.setCurrentItem(tab.getPosition());
                // notify해주어서 refresh
                mEnergyPagerAdapter.notifyDataSetChanged();
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {
                Log.e("", "onTabUnselected");
            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {
                Log.e("", "onTabReselected");
            }
        });

        return root;
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e("", this.getClass().getName() + "onResume()");
    }
}
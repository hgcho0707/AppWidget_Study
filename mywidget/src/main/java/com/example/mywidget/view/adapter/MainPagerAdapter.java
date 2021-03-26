package com.example.mywidget.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentPagerAdapter;

import com.example.mywidget.view.EverageFragment;
import com.example.mywidget.view.CarbonFragment;
import com.example.mywidget.view.EnergyFragment;

import java.util.ArrayList;

public class MainPagerAdapter extends FragmentPagerAdapter {

    public ArrayList<Fragment> mFragments = new ArrayList<>();

    // FragmnetManager를 받는 생성자
    public MainPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mFragments.add(new EnergyFragment());
        mFragments.add(new EverageFragment());
        mFragments.add(new CarbonFragment());
    }

    @NonNull
    @Override
    // 실제 Fragment를 반환
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    // 페이지의 개수를 반환
    public int getCount() {
        return mFragments.size();
    }

    /*@Override
    public int getItemPosition(@NonNull Object object) {

        return POSITION_NONE;
    }*/

}

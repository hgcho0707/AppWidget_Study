package com.example.mywidget.view.adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;

import com.example.mywidget.view.ElectroFragment;
import com.example.mywidget.view.GasFragment;
import com.example.mywidget.view.WaterFragment;

import java.util.ArrayList;

public class EnergyPagerAdapter extends FragmentStatePagerAdapter {

    public ArrayList<Fragment> mFragments = new ArrayList<>();

    // FragmnetManager를 받는 생성자
    public EnergyPagerAdapter(@NonNull FragmentManager fm) {
        super(fm);
        mFragments.add(new ElectroFragment());
        mFragments.add(new GasFragment());
        mFragments.add(new WaterFragment());
    }

    // 실제 Fragment 반환
    @NonNull
    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    // 페이지의 개수를 반환
    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public int getItemPosition(@NonNull Object object) {
        return POSITION_NONE;
    }

}

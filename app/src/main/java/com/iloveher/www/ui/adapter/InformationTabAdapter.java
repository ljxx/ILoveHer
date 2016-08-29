package com.iloveher.www.ui.adapter;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import com.iloveher.www.ui.base.BaseFragment;

import java.util.List;

public class InformationTabAdapter extends FragmentPagerAdapter {

    private List<BaseFragment> mFragments;
    private String[] mTitles;

    public InformationTabAdapter(FragmentManager fm) {
        super(fm);
    }

    public InformationTabAdapter(FragmentManager fm , List<BaseFragment> mFragments,String[] mTitles){
        super(fm);
        this.mFragments = mFragments;
        this.mTitles = mTitles;
    }

    @Override
    public Fragment getItem(int position) {
        return mFragments.get(position);
    }

    @Override
    public int getCount() {
        return mFragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position) {
        return mTitles[position];
    }
}

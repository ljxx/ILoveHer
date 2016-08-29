package com.iloveher.www.ui.mainfragment;

import android.app.FragmentManager;
import android.support.v4.view.ViewPager;
import android.util.TypedValue;

import com.iloveher.www.R;
import com.iloveher.www.ui.adapter.InformationTabAdapter;
import com.iloveher.www.ui.base.BaseFragment;
import com.iloveher.www.ui.informationFragment.BelleFragment;
import com.iloveher.www.ui.informationFragment.CampusFragment;
import com.iloveher.www.ui.informationFragment.CrossTalkFragment;
import com.iloveher.www.ui.informationFragment.EducationFragment;
import com.iloveher.www.ui.informationFragment.HealthFragment;
import com.iloveher.www.ui.informationFragment.KitchenFragment;
import com.iloveher.www.ui.informationFragment.RecommendFragment;
import com.iloveher.www.ui.informationFragment.RecreationFragment;
import com.iloveher.www.ui.informationFragment.SexesFragment;
import com.iloveher.www.ui.informationFragment.ShortFilmFragment;
import com.iloveher.www.ui.informationFragment.SocietyFragment;
import com.iloveher.www.ui.widget.PagerSlidingTabStrip;

import java.util.ArrayList;
import java.util.List;

public class InformationFragment extends BaseFragment {

    private PagerSlidingTabStrip mSlidingTab;
    private ViewPager mViewPager;
    private InformationTabAdapter mAdapter;
    private FragmentManager mFragmentManager;
    private String[] mPagerTitles = null;
    private List<BaseFragment> mFragments = new ArrayList<BaseFragment>();

    @Override
    protected int inflateView() {
        return R.layout.fragment_information;
    }

    @Override
    protected void initView() {
        mSlidingTab = (PagerSlidingTabStrip) mView.findViewById(R.id.mSlidingTab);
        mViewPager = (ViewPager) mView.findViewById(R.id.mViewPager);
        mPagerTitles = getResources().getStringArray(R.array.pagerTitles);
        initFragment();

    }

    private void initFragment() {
        mFragments.add(new RecommendFragment());
        mFragments.add(new HealthFragment());
        mFragments.add(new EducationFragment());
        mFragments.add(new RecreationFragment());
        mFragments.add(new ShortFilmFragment());
        mFragments.add(new CrossTalkFragment());
        mFragments.add(new KitchenFragment());
        mFragments.add(new SocietyFragment());
        mFragments.add(new CampusFragment());
        mFragments.add(new BelleFragment());
        mFragments.add(new SexesFragment());
        mAdapter = new InformationTabAdapter(getActivity().getSupportFragmentManager(),mFragments,mPagerTitles);
        mViewPager.setAdapter(mAdapter);

        final int pageMargin = (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 4, getResources().getDisplayMetrics());
        mViewPager.setPageMargin(pageMargin);

        mSlidingTab.setViewPager(mViewPager);
    }

    @Override
    protected void initListen() {

    }
}

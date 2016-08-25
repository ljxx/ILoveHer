package com.iloveher.www.ui;

import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.view.KeyEvent;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.iloveher.www.R;
import com.iloveher.www.ui.base.BaseFragmentActivity;
import com.iloveher.www.ui.fragment.CenterFragment;
import com.iloveher.www.ui.fragment.FindFragment;
import com.iloveher.www.ui.fragment.HomeFragment;
import com.iloveher.www.ui.fragment.MapFragment;
import com.iloveher.www.ui.fragment.UserFragment;
import com.iloveher.www.utils.FinishUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class MainActivity extends BaseFragmentActivity {

    private RadioGroup mRadioGroup;

    private boolean doubleClick = false;

    private List<String> mFragmentTags;
    private int mCurrentIndex;
    private final String CURRENTINDEX = "mCurrentIndex";
    private final int FRAGMENT_ZERO = 0;
    private final int FRAGMENT_FIRST = 1;
    private final int FRAGMENT_SECOND = 2;
    private final int FRAGMENT_THREE = 3;
    private final int FRAGMENT_FOUR = 4;

    private FragmentManager mFragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mFragmentManager = getSupportFragmentManager();
        /**
         * 初始化数据
         */
        initData(savedInstanceState);

        /**
         * 初始化view
         */
        initView();
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CURRENTINDEX,mCurrentIndex);
    }

    private void initData(Bundle savedInstanceState) {
        mFragmentTags = new ArrayList<String>(Arrays.asList("HomeFragment","MapFragment","CenterFragment","FindFragment","UserFragment"));
        mCurrentIndex = FRAGMENT_ZERO; //默认首页0
        if(savedInstanceState != null){
            mCurrentIndex = savedInstanceState.getInt(CURRENTINDEX);
            hindSaveFragment();
        }
    }

    /**
     * 隐藏保存Fragment
     */
    private void hindSaveFragment() {
        Fragment mFragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
        if(mFragment != null){
            mFragmentManager.beginTransaction().hide(mFragment).commit();
        }
    }

    /**
     * 初始化view
     */
    private void initView() {
        mRadioGroup = (RadioGroup) findViewById(R.id.mRadioGroup);
        mRadioGroup.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int position) {
                switch (position){
                    case R.id.mRBHome:
                        mCurrentIndex = FRAGMENT_ZERO;
                        break;
                    case R.id.mRBMap:
                        mCurrentIndex = FRAGMENT_FIRST;
                        break;
                    case R.id.mRBCenter:
                        mCurrentIndex = FRAGMENT_SECOND;
                        break;
                    case R.id.mRBFind:
                        mCurrentIndex = FRAGMENT_THREE;
                        break;
                    case R.id.mRBUser:
                        mCurrentIndex = FRAGMENT_FOUR;
                        break;
                    default:break;
                }
                showFragment();
            }
        });
        showFragment();
    }

    /**
     * 展示fragment
     */
    private void showFragment() {
        Fragment fragment = mFragmentManager.findFragmentByTag(mFragmentTags.get(mCurrentIndex));
        if(fragment == null){
            fragment = initFragment(mCurrentIndex);
        }

        FragmentTransaction fragmentTransaction = mFragmentManager.beginTransaction();
        for(int i = 0 ;i < mFragmentTags.size(); i++){
            Fragment ft = mFragmentManager.findFragmentByTag(mFragmentTags.get(i));
            if(ft != null && ft.isAdded()){
                fragmentTransaction.hide(ft);
            }
        }

        if(fragment.isAdded()){
            fragmentTransaction.show(fragment);
        } else {
            fragmentTransaction.replace(R.id.mFrameLayout,fragment,mFragmentTags.get(mCurrentIndex));
        }
        fragmentTransaction.commitAllowingStateLoss();
        mFragmentManager.executePendingTransactions();
    }

    private Fragment initFragment(int current) {
        switch (current){
            case FRAGMENT_ZERO:
                return  new HomeFragment();
            case FRAGMENT_FIRST:
                return new MapFragment();
            case FRAGMENT_SECOND:
                return new CenterFragment();
            case FRAGMENT_THREE:
                return new FindFragment();
            case FRAGMENT_FOUR:
                return new UserFragment();
            default:
                return null;
        }
    }

    /**
     * 退出
     */
    @Override
    public boolean dispatchKeyEvent(KeyEvent event) {
        if (event.getKeyCode() == KeyEvent.KEYCODE_BACK && event.getAction() == KeyEvent.ACTION_DOWN
                && event.getRepeatCount() == 0) {
            if (!doubleClick) {
                doubleClick = true;
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_LONG).show();
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        doubleClick = false;
                    }
                }, 2000);
                return true;
            } else {
                // 退出应用程序
                FinishUtils.AppExit();
            }
        }
        return super.dispatchKeyEvent(event);
    }
}

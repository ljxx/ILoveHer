package com.iloveher.www.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;

import com.iloveher.www.utils.FinishUtils;

public abstract class BaseFragmentActivity extends FragmentActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        FinishUtils.add(this);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        FinishUtils.finishActivity(this);
    }


    /*****************************以下内容需要具体分析后采用*****************************/
    public static BaseFragmentActivity mForegroundActivity = null;

    /*@Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        init();
        initView();
        initActionBar();
    }*/

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        this.mForegroundActivity = this;
    }


//    protected abstract void initActionBar();

//    protected abstract void initView();

//    protected abstract void init();

    public static BaseFragmentActivity getForegroundActivity() {
        // TODO Auto-generated method stub
        return mForegroundActivity;
    }
}

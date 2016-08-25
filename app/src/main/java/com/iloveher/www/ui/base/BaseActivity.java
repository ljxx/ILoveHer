package com.iloveher.www.ui.base;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public abstract class BaseActivity extends AppCompatActivity{
    public static BaseActivity mForegroundActivity = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // TODO Auto-generated method stub
        super.onCreate(savedInstanceState);
        init();
        initView();
        initActionBar();
    }

    @Override
    protected void onResume() {
        // TODO Auto-generated method stub
        super.onResume();
        this.mForegroundActivity = this;
    }


    protected abstract void initActionBar();

    protected abstract void initView();

    protected abstract void init();

    public static BaseActivity getForegroundActivity() {
        // TODO Auto-generated method stub
        return mForegroundActivity;
    }
}

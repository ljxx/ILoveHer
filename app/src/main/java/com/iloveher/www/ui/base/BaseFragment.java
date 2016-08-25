package com.iloveher.www.ui.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public abstract class BaseFragment extends Fragment {

    protected View mView;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(inflateView(),null);
        initView();
        return mView;
    }

    /**
     * 传递布局
     * @return
     */
    protected abstract int inflateView();

    /**
     * 初始化控件
     */
    protected abstract void initView();
}

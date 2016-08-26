package com.iloveher.www.ui.base;

import android.app.Application;
import android.os.Handler;
import android.os.Looper;

import com.facebook.drawee.backends.pipeline.Fresco;

public class BaseApplication extends Application {
    /**
     * 获取到主线程的上下文
     */
    private static BaseApplication mContext;
    /**
     * 获取到主线程的handler
     */
    private static Handler mMainThreadHandler;
    /**
     * 获取到主线程
     */
    private static Thread mMainThread;

    /**
     * 获取到主线程的轮询器
     */
    private static Looper mMainThreadLooper;

    /**
     * 获取到主线程id
     */
    private static int mMainTheadId;

    @Override
    public void onCreate() {
        // TODO Auto-generated method stub
        super.onCreate();
        init();
        this.mContext = this;
        this.mMainThreadHandler = new Handler();
        this.mMainThread = Thread.currentThread();
        this.mMainThreadLooper = getMainLooper();
        this.mMainTheadId = android.os.Process.myTid();
    }

    /**
     * 初始化第三方控件
     */
    private void init() {
        Fresco.initialize(this);
    }

    public static BaseApplication getApplication() {
        return mContext;
    }

    public static Handler getMainThreadHandler() {
        return mMainThreadHandler;
    }

    public static Thread getMainThread() {
        return mMainThread;
    }

    public static Looper getMainThreadLooper() {
        return mMainThreadLooper;
    }

    public static int getMainThreadId() {
        return mMainTheadId;
    }
}

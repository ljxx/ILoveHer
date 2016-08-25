package com.iloveher.www.utils;

import android.app.Activity;

import java.util.LinkedList;

/**
 * Created by ylx on 2016/08/25.
 * add : 将新打开的activity入组（称为组是因为这里我没有控制它的顺序，只是存下来）
 *remove：将新关闭的activity出组
 *finishAll：移除所有activity ，退出程序。
 *
 */
public class FinishUtils {

    public static LinkedList<Activity> mActivityList = new LinkedList<Activity>();

    public static void add(Activity activity) {
        mActivityList.add(activity);
    }

    public static void finishAll() {
        int size = mActivityList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (!mActivityList.get(i).isFinishing()) {
                    mActivityList.get(i).finish();
                }
            }
        }
    }

    public static void remove(Activity activity) {
        int size = mActivityList.size();
        if (size > 0) {
            for (int i = 0; i < size; i++) {
                if (mActivityList.get(i) == activity) {
                    mActivityList.remove(i);
                    break;
                }
            }
        }
    }
	
	/**
     * 添加Activity实例到mActivityList中，在onCreate()中调用
     *
     * @param activity
     */
    public static void addActivity(Activity activity) {
        mActivityList.add(activity);
    }

    /**
     * 从容器中删除多余的Activity实例，在onDestroy()中调用
     *
     * @param activity
     */
    public static void delActivity(Activity activity) {
        mActivityList.remove(activity);
    }

    /**
     * 从容器中关闭指定的Activity实例
     */
    public static void finishActivity(Activity activity) {
        mActivityList.remove(activity);
        if (activity != null && !activity.isFinishing()) {
            activity.finish();
            activity = null;
        }

    }

    /**
     * 结束指定类名的Activity
     */
    public static void finishActivity(Class<?> cls) {
        for (Activity activity : mActivityList) {
            if (activity.getClass().equals(cls)) {
                finishActivity(activity);
                break;
            }
        }
    }

    /**
     * 获取指定的Activity
     *
     */
    public static Activity getActivity(Class<?> cls) {
        if (mActivityList != null)
            for (Activity activity : mActivityList) {
                if (activity.getClass().equals(cls)) {
                    return activity;
                }
            }
        return null;
    }

    /**
     * 获取当前Activity（链表中最后一个添加进入的）
     */
    public static Activity currentActivity() {
        if (mActivityList != null) {
            Activity activity = mActivityList.getLast();
            return activity;
        }
        return null;
    }

    /**
     * 退出程序的方法
     */
    public static void AppExit() {
        for (Activity activity : mActivityList) {
            if (!activity.isFinishing()) {
                activity.finish();
            }
        }
        System.exit(0);
    }
}

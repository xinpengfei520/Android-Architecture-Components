package com.xpf.arch_component.presenter;

import com.xpf.arch_component.base.BaseActivityPresenter;
import com.xpf.arch_component.utils.LogUtils;

/**
 * Created by xpf on 2018/6/26 :)
 * GitHub:xinpengfei520
 * Function:
 */
public class ActivityPresenter implements BaseActivityPresenter {

    private static final String TAG = ActivityPresenter.class.getSimpleName();

    @Override
    public void onCreate() {
        LogUtils.i(TAG, "onCreate()");
    }

    @Override
    public void onStart() {
        LogUtils.i(TAG, "onStart()");
    }

    @Override
    public void onResume() {
        LogUtils.i(TAG, "onResume()");
    }

    @Override
    public void onPause() {
        LogUtils.i(TAG, "onPause()");
    }

    @Override
    public void onStop() {
        LogUtils.i(TAG, "onStop()");
    }

    @Override
    public void onDestroy() {
        LogUtils.i(TAG, "onDestroy()");
    }
}

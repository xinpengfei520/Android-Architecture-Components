package com.xpf.arch_component.observer;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleObserver;
import android.arch.lifecycle.OnLifecycleEvent;

import com.xpf.arch_component.base.BaseActivityPresenter;
import com.xpf.arch_component.utils.LogUtils;

/**
 * Created by xpf on 2018/6/26 :)
 * GitHub:xinpengfei520
 * Function:
 */
public class LocationLifeObserver implements BaseActivityPresenter,
        LifecycleObserver {

    private static final String TAG = LocationLifeObserver.class.getSimpleName();

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onCreate() {
        LogUtils.i(TAG, "onCreate()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_CREATE)
    @Override
    public void onStart() {
        LogUtils.i(TAG, "onStart()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_RESUME)
    @Override
    public void onResume() {
        LogUtils.i(TAG, "onResume()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_PAUSE)
    @Override
    public void onPause() {
        LogUtils.i(TAG, "onPause()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_STOP)
    @Override
    public void onStop() {
        LogUtils.i(TAG, "onStop()");
    }

    @OnLifecycleEvent(Lifecycle.Event.ON_DESTROY)
    @Override
    public void onDestroy() {
        LogUtils.i(TAG, "onDestroy()");
    }
}

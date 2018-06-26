package com.xpf.arch_component.activity;

import android.arch.lifecycle.Lifecycle;
import android.arch.lifecycle.LifecycleOwner;
import android.arch.lifecycle.LifecycleRegistry;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xpf.arch_component.R;
import com.xpf.arch_component.observer.ActivityLifeObserver;
import com.xpf.arch_component.observer.LocationLifeObserver;
import com.xpf.arch_component.utils.LogUtils;

public class DetailActivity extends AppCompatActivity implements LifecycleOwner {

    private static String TAG = DetailActivity.class.getSimpleName();
    private LifecycleRegistry mLifecycleRegistry;
    private ActivityLifeObserver activityLifeObserver;
    private LocationLifeObserver locationLifeObserver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        mLifecycleRegistry = new LifecycleRegistry(this);
        activityLifeObserver = new ActivityLifeObserver();
        locationLifeObserver = new LocationLifeObserver();
        // 注册需要监听的 Observer
        mLifecycleRegistry.addObserver(activityLifeObserver);
        mLifecycleRegistry.addObserver(locationLifeObserver);
    }

    @Override
    public Lifecycle getLifecycle() {
        return mLifecycleRegistry;
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        LogUtils.i(TAG, "onDestroy()");
        mLifecycleRegistry.removeObserver(activityLifeObserver);
        mLifecycleRegistry.removeObserver(locationLifeObserver);
    }
}

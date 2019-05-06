package com.xpf.arch_component.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.xpf.arch_component.R;
import com.xpf.arch_component.base.BaseActivityPresenter;
import com.xpf.arch_component.presenter.ActivityPresenter;

public class MvpLifecycleActivity extends AppCompatActivity {

    private BaseActivityPresenter mBasePresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mBasePresenter = new ActivityPresenter();
    }

    @Override
    protected void onStart() {
        super.onStart();
        mBasePresenter.onStart();
    }

    @Override
    protected void onResume() {
        super.onResume();
        mBasePresenter.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        mBasePresenter.onPause();
    }

    @Override
    protected void onStop() {
        super.onStop();
        mBasePresenter.onStop();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        mBasePresenter.onDestroy();
    }
}

package com.xpf.arch_component;

import android.app.Application;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
public class MyApplication extends Application {

    private static Application instance;

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }

    public static Application getInstance() {
        return instance;
    }
}

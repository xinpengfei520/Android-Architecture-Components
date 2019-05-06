package com.xpf.arch_component.base;

/**
 * Created by xpf on 2018/6/26 :)
 * GitHub:xinpengfei520
 * Function:
 */
public interface BaseViewModel<T> {

    T loadData();

    void clearData();
}

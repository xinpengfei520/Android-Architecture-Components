package com.xpf.arch_component.viewmodel;

import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;

import com.facebook.stetho.common.LogUtil;
import com.xpf.arch_component.base.BaseViewModel;
import com.xpf.arch_component.bean.User;
import com.xpf.arch_component.utils.RandomUtil;

/**
 * Created by xpf on 2018/6/26 :)
 * GitHub:xinpengfei520
 * Function:自定义的 UserViewModel 继承系统的 ViewModel，将 User 封装成 MutableLiveData
 */
public class UserViewModel extends ViewModel implements BaseViewModel<User> {

    private static final String TAG = "UserViewModel";
    private MutableLiveData<User> liveUser;

    public MutableLiveData<User> getData() {
        if (liveUser == null) {
            liveUser = new MutableLiveData<>();
        }

        liveUser.setValue(loadData());
        return this.liveUser;
    }

    public void changeData() {
        if (liveUser != null) {
            liveUser.setValue(loadData());
        }
    }

    @Override
    public User loadData() {
        User user = new User();
        user.setUserId(RandomUtil.getRandomNumber());
        user.setName(RandomUtil.getRandomName(6));
        user.setPhone(RandomUtil.getRandomPhone());
        LogUtil.i(TAG, "loadData(): " + user.toString());
        return user;
    }

    @Override
    public void clearData() {

    }
}

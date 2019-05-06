package com.xpf.arch_component.db;

import android.annotation.SuppressLint;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;
import android.arch.persistence.room.InvalidationTracker;
import android.support.annotation.NonNull;

import com.xpf.arch_component.db.dao.OrderDao;
import com.xpf.arch_component.db.dao.OrderDaoImpl;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:AbstractDatabase 的实现类
 */
public class DbManager extends AbstractDatabase {

    private static final String TAG = "DbManager";

    @Override
    public OrderDao getOrderDao() {
        return new OrderDaoImpl(getInstance());
    }

    @NonNull
    @Override
    protected SupportSQLiteOpenHelper createOpenHelper(DatabaseConfiguration config) {
        return new SupportSQLiteOpenHelperImpl(config);
    }

    @SuppressLint("RestrictedApi")
    @NonNull
    @Override
    protected InvalidationTracker createInvalidationTracker() {
        return new InvalidationTracker(getInstance(), "orders");
    }

    @Override
    public void clearAllTables() {
        getInstance().clearAllTables();
    }
}

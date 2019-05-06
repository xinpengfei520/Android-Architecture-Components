package com.xpf.arch_component.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.support.annotation.NonNull;

import com.facebook.stetho.common.LogUtil;
import com.xpf.arch_component.MyApplication;
import com.xpf.arch_component.bean.Order;
import com.xpf.arch_component.db.dao.OrderDao;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
@Database(entities = {Order.class}, version = 1)
public abstract class AbstractDatabase extends RoomDatabase {

    private static final String TAG = "AbstractDatabase";
    /**
     * 数据库名称
     */
    private static final String DB_NAME = "my_app_db";

    public abstract OrderDao getOrderDao();

    private static volatile AbstractDatabase INSTANCE;

    static AbstractDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (DbManager.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(MyApplication.getInstance(), AbstractDatabase.class, DB_NAME)
                            .addCallback(new RoomDatabase.Callback() {
                                @Override
                                public void onCreate(@NonNull SupportSQLiteDatabase db) {
                                    super.onCreate(db);
                                    LogUtil.i(TAG, "onCreate()");
                                }

                                @Override
                                public void onOpen(@NonNull SupportSQLiteDatabase db) {
                                    super.onOpen(db);
                                    LogUtil.i(TAG, "onOpen()");
                                }
                            })
                            .allowMainThreadQueries()
                            .build();
                }
            }
        }

        return INSTANCE;
    }
}

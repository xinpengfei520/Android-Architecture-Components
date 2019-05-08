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
 * Function:App 数据库创建的单例类，如果有其他表也可以在注解中进行添加
 */
@Database(entities = {Order.class}, version = 1)
public abstract class AppDatabase extends RoomDatabase {

    private static final String TAG = "AppDatabase";
    /**
     * 数据库名称
     */
    private static final String DB_NAME = "my_app_db";

    /**
     * 获取 Order 表的 DAO
     */
    public abstract OrderDao getOrderDao();

    private static volatile AppDatabase INSTANCE;

    public static AppDatabase getInstance() {
        if (INSTANCE == null) {
            synchronized (AppDatabase.class) {
                if (INSTANCE == null) {
                    INSTANCE = Room
                            .databaseBuilder(MyApplication.getInstance(), AppDatabase.class, DB_NAME)
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

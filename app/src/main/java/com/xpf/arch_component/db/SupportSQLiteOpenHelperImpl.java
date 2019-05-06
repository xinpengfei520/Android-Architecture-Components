package com.xpf.arch_component.db;

import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.db.SupportSQLiteOpenHelper;
import android.arch.persistence.room.DatabaseConfiguration;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
public class SupportSQLiteOpenHelperImpl implements SupportSQLiteOpenHelper {

    private DatabaseConfiguration mConfig;

    public SupportSQLiteOpenHelperImpl(DatabaseConfiguration config) {
        this.mConfig = config;
    }

    @Override
    public String getDatabaseName() {
        return null;
    }

    @Override
    public void setWriteAheadLoggingEnabled(boolean enabled) {

    }

    @Override
    public SupportSQLiteDatabase getWritableDatabase() {
        return null;
    }

    @Override
    public SupportSQLiteDatabase getReadableDatabase() {
        return null;
    }

    @Override
    public void close() {

    }
}

package com.xpf.arch_component.db.adapter;

import android.annotation.SuppressLint;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.RoomDatabase;

import com.xpf.arch_component.bean.Order;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:删除数据的适配器
 */
public class DeletionAdapterOfOrder extends EntityDeletionOrUpdateAdapter<Order> {

    /**
     * Creates a DeletionOrUpdateAdapter that can delete or update the entity type T on the given
     * database.
     *
     * @param database The database to delete / update the item in.
     */
    @SuppressLint("RestrictedApi")
    public DeletionAdapterOfOrder(RoomDatabase database) {
        super(database);
    }

    @Override
    protected String createQuery() {
        return "DELETE FROM `orders` WHERE `order_id` = ?";
    }

    @Override
    protected void bind(SupportSQLiteStatement statement, Order entity) {
        statement.bindLong(1, entity.orderId);
    }
}

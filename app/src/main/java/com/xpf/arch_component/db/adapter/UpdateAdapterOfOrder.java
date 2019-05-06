package com.xpf.arch_component.db.adapter;

import android.annotation.SuppressLint;
import android.arch.persistence.db.SupportSQLiteStatement;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.RoomDatabase;

import com.xpf.arch_component.bean.Order;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:修改数据的适配器
 */
public class UpdateAdapterOfOrder extends EntityDeletionOrUpdateAdapter<Order> {

    /**
     * Creates a DeletionOrUpdateAdapter that can delete or update the entity type T on the given
     * database.
     *
     * @param database The database to delete / update the item in.
     */
    @SuppressLint("RestrictedApi")
    public UpdateAdapterOfOrder(RoomDatabase database) {
        super(database);
    }

    @Override
    protected String createQuery() {
        return "UPDATE `orders` SET `order_id` = ?,`address` = ?,`owner_name` = ?,`owner_phone` = ? WHERE `order_id` = ?";
    }

    @Override
    protected void bind(SupportSQLiteStatement statement, Order entity) {
        statement.bindLong(1, entity.orderId);
        if (entity.address == null) {
            statement.bindNull(2);
        } else {
            statement.bindString(2, entity.address);
        }
        if (entity.ownerName == null) {
            statement.bindNull(3);
        } else {
            statement.bindString(3, entity.ownerName);
        }
        statement.bindString(4, entity.ownerPhone);
    }
}

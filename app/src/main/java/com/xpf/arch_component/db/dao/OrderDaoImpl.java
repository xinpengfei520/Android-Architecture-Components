package com.xpf.arch_component.db.dao;

import android.annotation.SuppressLint;
import android.arch.persistence.room.EntityDeletionOrUpdateAdapter;
import android.arch.persistence.room.EntityInsertionAdapter;
import android.arch.persistence.room.RoomDatabase;
import android.arch.persistence.room.RoomSQLiteQuery;
import android.database.Cursor;

import com.xpf.arch_component.bean.Order;
import com.xpf.arch_component.db.adapter.DeletionAdapterOfOrder;
import com.xpf.arch_component.db.adapter.InsertionAdapterOfOrder;
import com.xpf.arch_component.db.adapter.UpdateAdapterOfOrder;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:Order 增删改查实现类
 */
public class OrderDaoImpl implements OrderDao {

    private RoomDatabase mRoomDatabase;
    private EntityInsertionAdapter<Order> insertionAdapterOfOrder;
    private EntityDeletionOrUpdateAdapter<Order> deletionAdapterOfOrder;
    private EntityDeletionOrUpdateAdapter<Order> updateAdapterOfOrder;

    private static final String SELECT_FROM_ORDERS = "SELECT * FROM orders";

    /**
     * Constructor
     */
    public OrderDaoImpl(RoomDatabase roomDatabase) {
        this.mRoomDatabase = roomDatabase;
        insertionAdapterOfOrder = new InsertionAdapterOfOrder(mRoomDatabase);
        deletionAdapterOfOrder = new DeletionAdapterOfOrder(mRoomDatabase);
        updateAdapterOfOrder = new UpdateAdapterOfOrder(mRoomDatabase);
    }

    @SuppressLint("RestrictedApi")
    @Override
    public List<Order> loadAllOrders() {
        @SuppressLint("RestrictedApi")
        RoomSQLiteQuery roomSQLiteQuery = RoomSQLiteQuery.acquire(SELECT_FROM_ORDERS, 0);

        try (Cursor cursor = mRoomDatabase.query(roomSQLiteQuery)) {
            final int cursorIndexOfOrderId = cursor.getColumnIndexOrThrow("order_id");
            final int cursorIndexOfAddress = cursor.getColumnIndexOrThrow("address");
            final int cursorIndexOfOwnerName = cursor.getColumnIndexOrThrow("owner_name");
            final int cursorIndexOfOwnerPhone = cursor.getColumnIndexOrThrow("owner_phone");
            final int cursorIndexOfStreet = cursor.getColumnIndexOrThrow("street");
            final int cursorIndexOfState = cursor.getColumnIndexOrThrow("state");
            final int cursorIndexOfCity = cursor.getColumnIndexOrThrow("city");
            final int cursorIndexOfPostCode = cursor.getColumnIndexOrThrow("post_code");
            final List<Order> result = new ArrayList<>(cursor.getCount());
            while (cursor.moveToNext()) {
                final Order item;
                final Order.OwnerAddress tmpOwnerAddress;

                if (!(cursor.isNull(cursorIndexOfStreet) && cursor.isNull(cursorIndexOfState) && cursor.isNull(cursorIndexOfCity) && cursor.isNull(cursorIndexOfPostCode))) {
                    tmpOwnerAddress = new Order.OwnerAddress();
                    tmpOwnerAddress.street = cursor.getString(cursorIndexOfStreet);
                    tmpOwnerAddress.state = cursor.getString(cursorIndexOfState);
                    tmpOwnerAddress.city = cursor.getString(cursorIndexOfCity);
                    tmpOwnerAddress.postCode = cursor.getInt(cursorIndexOfPostCode);
                } else {
                    tmpOwnerAddress = null;
                }

                item = new Order();
                item.orderId = cursor.getLong(cursorIndexOfOrderId);
                item.address = cursor.getString(cursorIndexOfAddress);
                item.ownerName = cursor.getString(cursorIndexOfOwnerName);
                item.ownerPhone = cursor.getString(cursorIndexOfOwnerPhone);
                item.ownerAddress = tmpOwnerAddress;
                result.add(item);
            }

            return result;

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            roomSQLiteQuery.release();
        }

        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void insertAll(Order... orders) {
        mRoomDatabase.beginTransaction();
        try {
            insertionAdapterOfOrder.insert(orders);
            mRoomDatabase.setTransactionSuccessful();
        } finally {
            mRoomDatabase.endTransaction();
        }
    }

    @Override
    public List<Order> queryOrderById(long[] orderIds) {
        return null;
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void deleteOrder(Order... orders) {
        mRoomDatabase.beginTransaction();
        try {
            deletionAdapterOfOrder.handleMultiple(orders);
            mRoomDatabase.setTransactionSuccessful();
        } finally {
            mRoomDatabase.endTransaction();
        }
    }

    @SuppressLint("RestrictedApi")
    @Override
    public void updateOrder(Order... orders) {
        mRoomDatabase.beginTransaction();
        try {
            updateAdapterOfOrder.handleMultiple(orders);
            mRoomDatabase.setTransactionSuccessful();
        } finally {
            mRoomDatabase.endTransaction();
        }
    }
}

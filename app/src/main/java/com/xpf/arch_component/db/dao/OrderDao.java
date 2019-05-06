package com.xpf.arch_component.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.xpf.arch_component.bean.Order;

import java.util.List;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
@Dao
public interface OrderDao {

    @Query("SELECT * FROM orders")
    List<Order> loadAllOrders();

    @Insert
    void insertAll(Order... orders);

    @Query("SELECT * FROM orders WHERE order_id IN (:orderIds)")
    List<Order> queryOrderById(long[] orderIds);

    @Delete
    void deleteOrder(Order... orders);

    @Update
    void updateOrder(Order... orders);
}

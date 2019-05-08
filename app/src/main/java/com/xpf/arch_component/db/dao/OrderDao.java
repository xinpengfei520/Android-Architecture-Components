package com.xpf.arch_component.db.dao;

import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.OnConflictStrategy;
import android.arch.persistence.room.Query;
import android.arch.persistence.room.Update;

import com.xpf.arch_component.bean.Order;

import java.util.List;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:定义 Order 表的 CRUD 接口
 */
@Dao
public interface OrderDao {

    /**
     * 查询 orders 表的所有数据
     *
     * @return Order list
     */
    @Query("SELECT * FROM orders")
    List<Order> selectAllFromOrders();

    /**
     * 插入数据到 Order 表中，当插入冲突时的策略是替换旧数据
     *
     * @param orders
     */
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    void insertAll(Order... orders);

    /**
     * 通过 orderId 查询 Order
     *
     * @param orderIds
     * @return
     */
    @Query("SELECT * FROM orders WHERE order_id IN (:orderIds)")
    List<Order> queryOrderByOrderId(long[] orderIds);

    /**
     * 删除 Order
     *
     * @param orders
     */
    @Delete
    void deleteOrder(Order... orders);

    /**
     * 更新数据
     *
     * @param orders
     */
    @Update
    void updateOrder(Order... orders);
}

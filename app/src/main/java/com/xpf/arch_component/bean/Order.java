package com.xpf.arch_component.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:定义订单表
 */
@Entity(tableName = "orders")
public class Order {

    /**
     * 订单 id (主键)
     */
    @PrimaryKey
    @ColumnInfo(name = "order_id")
    private long orderId;
    /**
     * 姓名
     */
    @ColumnInfo(name = "name")
    private String name;
    /**
     * 手机
     */
    @ColumnInfo(name = "phone")
    private String phone;
    /**
     * 订单地址
     */
    @ColumnInfo(name = "address")
    private String address;

    public long getOrderId() {
        return orderId;
    }

    public void setOrderId(long orderId) {
        this.orderId = orderId;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    /*
     * 使用到的主要注解：
     *
     * @Entity(tableName = "orders")   //   定义表名；
     * @PrimaryKey                     //   定义主键；
     * @ColumnInfo(name = "order_id")  //   定义数据表中的字段名；
     * @Ignore                         //   指示 Room 需要忽略的字段或方法；
     * @Embedded                       //   指定嵌入实体
     * @Query("SELECT * FROM orders")  //   定义查询数据接口；
     * @Insert                         //   定义增加数据接口；
     * @Delete                         //   定义删除数据接口；
     * @Update                         //   定义更新数据接口；
     * @Database                       //   定义数据库信息，表信息，数据库版本
     *
     */
}

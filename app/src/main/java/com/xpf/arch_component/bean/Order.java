package com.xpf.arch_component.bean;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Embedded;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.Ignore;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by x-sir on 2019/5/6 :)
 * Function:
 */
@Entity(tableName = "orders")
public class Order {

    /**
     * 主键
     */
    @PrimaryKey
    @ColumnInfo(name = "order_id")
    public long orderId;
    @ColumnInfo(name = "address")
    public String address;
    @ColumnInfo(name = "owner_name")
    public String ownerName;
    @ColumnInfo(name = "owner_phone")
    public String ownerPhone;

    /**
     * 指示 Room 需要忽略的字段或方法
     */
    @Ignore
    public String ignoreText;

    @Embedded
    public OwnerAddress ownerAddress;

    public static class OwnerAddress {
        public String street;
        public String state;
        public String city;
        @ColumnInfo(name = "post_code")
        public int postCode;
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

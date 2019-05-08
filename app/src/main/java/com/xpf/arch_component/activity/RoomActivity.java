package com.xpf.arch_component.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import com.xpf.arch_component.R;
import com.xpf.arch_component.bean.Order;
import com.xpf.arch_component.db.DbManager;

/**
 * Created by x-sir on 2019/5/7 :)
 * Function:
 */
public class RoomActivity extends AppCompatActivity {

    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private Button btnQuery;
    private DbManager dbManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnQuery = findViewById(R.id.btnQuery);
        dbManager = new DbManager();
        initListener();
    }

    private void initListener() {
        btnAdd.setOnClickListener(v -> insert());
        btnDelete.setOnClickListener(v -> delete());
        btnUpdate.setOnClickListener(v -> update());
        btnQuery.setOnClickListener(v -> query());
    }

    private void query() {

    }

    private void update() {

    }

    private void delete() {

    }

    private void insert() {
        Order order = new Order();
        order.orderId = 1L;
        order.ownerName = "hello";
        order.ownerPhone = "110";
        dbManager.getOrderDao().insertAll(order);
    }
}

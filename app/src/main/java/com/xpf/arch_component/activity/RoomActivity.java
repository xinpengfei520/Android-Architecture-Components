package com.xpf.arch_component.activity;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.Button;

import com.xpf.arch_component.R;
import com.xpf.arch_component.adapter.OrderAdapter;
import com.xpf.arch_component.bean.Order;
import com.xpf.arch_component.db.AppDatabase;
import com.xpf.arch_component.utils.RandomUtil;

import java.util.List;

/**
 * Created by x-sir on 2019/5/7 :)
 * Function:
 */
public class RoomActivity extends AppCompatActivity {

    private static final String TAG = "RoomActivity";
    private Button btnAdd;
    private Button btnDelete;
    private Button btnUpdate;
    private Button btnQuery;
    private RecyclerView recyclerView;
    private OrderAdapter orderAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_room);

        btnAdd = findViewById(R.id.btnAdd);
        btnDelete = findViewById(R.id.btnDelete);
        btnUpdate = findViewById(R.id.btnUpdate);
        btnQuery = findViewById(R.id.btnQuery);
        recyclerView = findViewById(R.id.recyclerView);
        initListener();
    }

    private void initListener() {
        btnAdd.setOnClickListener(v -> insert());
        btnDelete.setOnClickListener(v -> delete());
        btnUpdate.setOnClickListener(v -> update());
        btnQuery.setOnClickListener(v -> query());
    }

    private void query() {
        List<Order> orders = AppDatabase.getInstance().getOrderDao().selectAllFromOrders();
        orderAdapter = new OrderAdapter(orders);
        recyclerView.setAdapter(orderAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.VERTICAL, false));
    }

    private void update() {
        AppDatabase.getInstance().getOrderDao().updateOrder();
    }

    private void delete() {
        AppDatabase.getInstance().getOrderDao().deleteOrder();
    }

    private void insert() {
        Order order = new Order();
        order.setOrderId(Long.parseLong(RandomUtil.getRandomNumber()));
        order.setName(RandomUtil.getRandomName(6));
        order.setPhone(RandomUtil.getRandomPhone());
        order.setAddress(RandomUtil.getAddress());

        AppDatabase.getInstance().getOrderDao().insertAll(order);
    }
}

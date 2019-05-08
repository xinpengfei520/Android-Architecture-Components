package com.xpf.arch_component.adapter;

import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.xpf.arch_component.R;
import com.xpf.arch_component.bean.Order;

import java.util.List;

/**
 * Created by x-sir on 2019/5/8 :)
 * Function:
 */
public class OrderAdapter extends BaseQuickAdapter<Order, BaseViewHolder> {

    public OrderAdapter(@Nullable List<Order> data) {
        super(R.layout.item_order, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, Order item) {
        helper.setText(R.id.tvContent, item.getName() + "," + item.getPhone() + "," + item.getAddress() + "," + item.getOrderId());
    }
}

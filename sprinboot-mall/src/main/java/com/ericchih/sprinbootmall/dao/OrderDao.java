package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {
    Integer createOrder(Integer userId , Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}

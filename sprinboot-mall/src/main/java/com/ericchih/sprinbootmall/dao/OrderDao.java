package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.dto.OrderQueryParams;
import com.ericchih.sprinbootmall.model.Order;
import com.ericchih.sprinbootmall.model.OrderItem;

import java.util.List;

public interface OrderDao {

    Integer countOrder(OrderQueryParams orderQueryParams);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Order getOrderById(Integer orderId);

    List<OrderItem> getOrderItemByOrderId(Integer orderId);

    Integer createOrder(Integer userId , Integer totalAmount);

    void createOrderItems(Integer orderId, List<OrderItem> orderItemList);
}

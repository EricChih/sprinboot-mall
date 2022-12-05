package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dao.OrderDao;
import com.ericchih.sprinbootmall.dto.CreateOrderRequest;
import com.ericchih.sprinbootmall.dto.OrderQueryParams;
import com.ericchih.sprinbootmall.model.Order;

import java.util.List;

public interface OrderService {

    Order getOrderById(Integer orderId);

    List<Order> getOrders(OrderQueryParams orderQueryParams);

    Integer countOrder(OrderQueryParams orderQueryParams);
    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

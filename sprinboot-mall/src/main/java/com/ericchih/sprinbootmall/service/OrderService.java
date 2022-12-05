package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dao.OrderDao;
import com.ericchih.sprinbootmall.dto.CreateOrderRequest;
import com.ericchih.sprinbootmall.model.Order;

public interface OrderService {

    Order getOrderById(Integer orderId);


    Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest);
}

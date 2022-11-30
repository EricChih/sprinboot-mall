package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dao.OrderDao;
import com.ericchih.sprinbootmall.dto.CreateOrderRequest;

public interface OrderService {

Integer createOrder (Integer userId, CreateOrderRequest createOrderRequest);
}

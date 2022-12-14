package com.ericchih.sprinbootmall.service.Impl;

import com.ericchih.sprinbootmall.dao.OrderDao;
import com.ericchih.sprinbootmall.dao.ProductDao;
import com.ericchih.sprinbootmall.dao.UserDao;
import com.ericchih.sprinbootmall.dto.BuyItem;
import com.ericchih.sprinbootmall.dto.CreateOrderRequest;
import com.ericchih.sprinbootmall.dto.OrderQueryParams;
import com.ericchih.sprinbootmall.model.Order;
import com.ericchih.sprinbootmall.model.OrderItem;
import com.ericchih.sprinbootmall.model.Product;
import com.ericchih.sprinbootmall.model.User;
import com.ericchih.sprinbootmall.service.OrderService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;

@Component
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderDao orderDao;
    @Autowired
    private ProductDao productDao;

    @Autowired
    private UserDao userDao;

    private static final Logger log= LoggerFactory.getLogger(OrderServiceImpl.class);

    @Override
    public Order getOrderById(Integer orderId) {
        Order order=orderDao.getOrderById(orderId);

        List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(orderId);

        order.setOrderItemList(orderItemList);

        return order;
    }

    @Override
    public List<Order> getOrders(OrderQueryParams orderQueryParams) {
        List<Order> orderList = orderDao.getOrders(orderQueryParams);

        for(Order order:orderList){
            List<OrderItem> orderItemList = orderDao.getOrderItemByOrderId(order.getOrderId());

            order.setOrderItemList(orderItemList);
        }

        return orderList;
    }

    @Override
    public Integer countOrder(OrderQueryParams orderQueryParams) {
        return orderDao.countOrder(orderQueryParams);
    }

    @Transactional
    @Override
    public Integer createOrder(Integer userId, CreateOrderRequest createOrderRequest) {
        //??????User ????????????
        User user = userDao.getUserById(userId);

        if(user == null){
            log.warn("??? userId {} ?????????", userId);
            throw new ResponseStatusException(HttpStatus.BAD_REQUEST);

        }

        int totalAmount = 0;
        List<OrderItem> orderItemList=new ArrayList<>();

        for (BuyItem buyItem : createOrderRequest.getBuyItemList()) {
            Product product = productDao.getProductById(buyItem.getProductId());

            //?????? product ?????????????????????????????????
            if (product == null){
                log.warn("?????? {} ?????????", buyItem.getProductId());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }else if (product.getStock()<buyItem.getQuantity()){
                log.warn("?????? {} ???????????????????????????????????????????????? {}?????????????????? {}",
                        buyItem.getProductId(),product.getStock(),buyItem.getQuantity());
                throw new ResponseStatusException(HttpStatus.BAD_REQUEST);
            }

            //??????????????????
            productDao.updateStock(product.getProductId(),product.getStock()-buyItem.getQuantity());

            //???????????????
            int amount = buyItem.getQuantity() * product.getPrice();
            System.out.println(amount);
            totalAmount = totalAmount + amount;

            //?????? BuyItem to OrderItem
            OrderItem orderItem=new OrderItem();
            orderItem.setProductId(buyItem.getProductId());
            orderItem.setQuantity(buyItem.getQuantity());
            orderItem.setAmount(amount);

            orderItemList.add(orderItem);
        }

        //????????????
        Integer orderId = orderDao.createOrder(userId,totalAmount);

        orderDao.createOrderItems(orderId,orderItemList);

        return orderId;
    }
}

package com.ericchih.sprinbootmall.service.Impl;

import com.ericchih.sprinbootmall.dao.ProductDao;
import com.ericchih.sprinbootmall.model.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import com.ericchih.sprinbootmall.service.ProductService;

@Component
public class ProductServiceImpl implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Override
    public Product getProductById(Integer productId) {
        return productDao.getProductById(productId);
    }
}
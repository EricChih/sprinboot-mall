package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dto.ProductRequest;
import com.ericchih.sprinbootmall.model.Product;

public interface ProductService {
    Product getProductById(Integer productId) ;

    Integer createProduct(ProductRequest productRequest);
}

package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.dto.ProductRequest;
import com.ericchih.sprinbootmall.model.Product;

public interface ProductDao {

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);
}

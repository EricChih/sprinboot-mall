package com.ericchih.sprinbootmall.service;

import com.ericchih.sprinbootmall.dao.ProductQueryParams;
import com.ericchih.sprinbootmall.dto.ProductRequest;
import com.ericchih.sprinbootmall.model.Product;

import java.util.List;

public interface ProductService {

    List<Product> getProducts(ProductQueryParams productQueryParams );

    Product getProductById(Integer productId) ;

    Integer createProduct(ProductRequest productRequest);

    void updateProduct (Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);
}

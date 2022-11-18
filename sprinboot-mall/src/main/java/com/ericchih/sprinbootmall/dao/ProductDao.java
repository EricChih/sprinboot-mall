package com.ericchih.sprinbootmall.dao;
import com.ericchih.sprinbootmall.dto.ProductRequest;
import com.ericchih.sprinbootmall.model.Product;

import java.util.List;

public interface ProductDao {

    List<Product> getProducts(ProductQueryParams productQueryParams);

    Product getProductById (Integer productId);

    Integer createProduct(ProductRequest productRequest);

    void updateProduct (Integer productId,ProductRequest productRequest);

    void deleteProductById(Integer productId);



}

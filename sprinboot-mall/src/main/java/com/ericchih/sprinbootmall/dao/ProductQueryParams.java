package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.constant.ProductCategory;

public class ProductQueryParams {

    private ProductCategory category;
    private String search;

    public void setCategory(ProductCategory category) {
        this.category = category;
    }

    public String getSearch() {
        return search;
    }

    public void setSearch(String search) {
        this.search = search;
    }

    public ProductCategory getCategory(){
        return category;
    }
}

package com.ericchih.sprinbootmall.dao;

import com.ericchih.sprinbootmall.constant.ProductCategory;

public class ProductQueryParams {

    private ProductCategory category;
    private String search;

    private String orderBy;

    private String sort;

    public String getOrderBy() {
        return orderBy;
    }

    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }

    public String getSort() {
        return sort;
    }

    public void setSort(String sort) {
        this.sort = sort;
    }

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

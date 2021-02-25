package com.rizal.belajarspring.model;

import com.rizal.belajarspring.entity.ProductEntity;

import java.util.List;

public class OrderRequest {

    private Integer customerId;
    private List<ProductEntity> orderItems;


    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public List<ProductEntity> getOrderItems() {
        return orderItems;
    }

    public void setOrderItems(List<ProductEntity> orderItems) {
        this.orderItems = orderItems;
    }
}

package com.rizal.belajarspring.model;

import com.rizal.belajarspring.entity.OrderDetailEntity;
import com.rizal.belajarspring.entity.OrderEntity;

import java.util.List;

public class OrderResponse {

    private OrderEntity order;
    private List<OrderDetailEntity> items;

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public List<OrderDetailEntity> getItems() {
        return items;
    }

    public void setItems(List<OrderDetailEntity> items) {
        this.items = items;
    }
}

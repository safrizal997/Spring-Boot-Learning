package com.rizal.belajarspring.entity;

import javax.persistence.*;
import java.util.UUID;

@Entity
@Table(name = "order_detail_tbl")
public class OrderDetailEntity {

    @Id
    @Column(name = "order_detail_id")
    private String orderDetailId = UUID.randomUUID().toString();

    @Column(name = "order_id", nullable = false)
    private String orderId;

    @OneToOne
    @JoinColumn(name = "product_id")
    private ProductEntity productId;


    public OrderDetailEntity() {
    }

    public OrderDetailEntity(String orderId, ProductEntity productId) {
        this.orderId = orderId;
        this.productId = productId;
    }


    public String getOrderDetailId() {
        return orderDetailId;
    }

    public void setOrderDetailId(String orderDetailId) {
        this.orderDetailId = orderDetailId;
    }

    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public ProductEntity getProductId() {
        return productId;
    }

    public void setProductId(ProductEntity productId) {
        this.productId = productId;
    }
}


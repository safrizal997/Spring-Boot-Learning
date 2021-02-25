package com.rizal.belajarspring.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Entity
@Table(name = "order_tbl")
public class OrderEntity {

    @Id
    @Column(name = "order_id")
    private String orderId = UUID.randomUUID().toString();

    @Column(name = "trx_id", nullable = false)
    private String trxId = "TRX-"+ new Date(System.currentTimeMillis()).toString();

    @OneToOne
    @JoinColumn(name = "customer_id")
    private CustomerEntity customerId;


    @Column(name = "order_date")
    private Date orderDate = new Date();

    public OrderEntity() {
    }

    public OrderEntity(CustomerEntity customerId) {
        this.customerId = customerId;
    }


    public String getOrderId() {
        return orderId;
    }

    public void setOrderId(String orderId) {
        this.orderId = orderId;
    }

    public String getTrxId() {
        return trxId;
    }

    public void setTrxId(String trxId) {
        this.trxId = trxId;
    }

    public CustomerEntity getCustomerId() {
        return customerId;
    }

    public void setCustomerId(CustomerEntity customerId) {
        this.customerId = customerId;
    }

    public Date getOrderDate() {
        return orderDate;
    }

    public void setOrderDate(Date orderDate) {
        this.orderDate = orderDate;
    }
}

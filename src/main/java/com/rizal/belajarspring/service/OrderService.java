package com.rizal.belajarspring.service;


import com.rizal.belajarspring.entity.OrderEntity;
import com.rizal.belajarspring.model.OrderRequest;
import com.rizal.belajarspring.model.OrderResponse;

import java.util.List;

public interface OrderService {

    List<OrderResponse> getAllOrder();

    OrderResponse getOrder(String orderId);

    OrderResponse addOrder(OrderRequest orderRequest);


}

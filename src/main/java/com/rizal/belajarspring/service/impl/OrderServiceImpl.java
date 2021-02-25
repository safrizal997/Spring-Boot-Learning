package com.rizal.belajarspring.service.impl;

import com.rizal.belajarspring.entity.CustomerEntity;
import com.rizal.belajarspring.entity.OrderDetailEntity;
import com.rizal.belajarspring.entity.OrderEntity;
import com.rizal.belajarspring.entity.ProductEntity;
import com.rizal.belajarspring.model.OrderRequest;
import com.rizal.belajarspring.model.OrderResponse;
import com.rizal.belajarspring.repository.CustomerEntityRepository;
import com.rizal.belajarspring.repository.OrderDetailEntityRepository;
import com.rizal.belajarspring.repository.OrderEntityRepository;
import com.rizal.belajarspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderEntityRepository orderEntityRepository;

    @Autowired
    OrderDetailEntityRepository orderDetailEntityRepository;

    @Autowired
    CustomerEntityRepository customerEntityRepository;


    @Override
    public List<OrderResponse> getAllOrder() {
        List<OrderEntity> orders = orderEntityRepository.findAll();
        List<OrderResponse> orderResponses = new ArrayList<>();


        for (OrderEntity order : orders) {
            OrderResponse orderResponse = new OrderResponse();

            List<OrderDetailEntity> orderDetails = orderDetailEntityRepository
                    .findByOrderId(order.getOrderId());

            orderResponse.setOrder(order);
            orderResponse.setItems(orderDetails);

            orderResponses.add(orderResponse);
        }

        return orderResponses;
    }

    @Override
    public OrderResponse getOrder(String orderId) {
        Optional<OrderEntity> order = orderEntityRepository.findById(orderId);

        if (order.isPresent()) {

            OrderEntity ord = order.get();

            List<OrderDetailEntity> orderDetails = orderDetailEntityRepository
                    .findByOrderId(ord.getOrderId());

            OrderResponse orderResponse = new OrderResponse();

            orderResponse.setOrder(ord);
            orderResponse.setItems(orderDetails);

            return orderResponse;
        }

        return null;
    }

    @Override
    public OrderResponse addOrder(OrderRequest orderRequest) {

        // 01. Get data from parameter
        Optional<CustomerEntity> customer = customerEntityRepository.findById(orderRequest.getCustomerId());

        if (customer.isPresent()) {
            OrderEntity order = new OrderEntity(customer.get());
            List<ProductEntity> orderItems = orderRequest.getOrderItems();

            // 02. Save to orderDB
            OrderEntity newOrderFromDB = orderEntityRepository.save(order);
            List<OrderDetailEntity> orderDetails = new ArrayList<>();

            // 03. Looping and get orderItem
            for (ProductEntity product : orderItems) {
                orderDetails.add(
                        new OrderDetailEntity(newOrderFromDB.getOrderId(), product)
                );
            }

            // 04. Save all orderDetail
            List<OrderDetailEntity> orderDetailFromDB = orderDetailEntityRepository.saveAll(orderDetails);

            // 05. return
            OrderResponse response = new OrderResponse();
            response.setOrder(newOrderFromDB);
            response.setItems(orderDetailFromDB);

            return response;

        }
        // 06. Default Return
        return null;
    }
}

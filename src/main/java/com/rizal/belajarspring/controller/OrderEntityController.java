package com.rizal.belajarspring.controller;


import com.rizal.belajarspring.entity.OrderEntity;
import com.rizal.belajarspring.model.OrderRequest;
import com.rizal.belajarspring.model.OrderResponse;
import com.rizal.belajarspring.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(path = "/api/v1/orders", produces = MediaType.APPLICATION_JSON_VALUE)
public class OrderEntityController {

    @Autowired
    OrderService orderService;

    @GetMapping
    public List<OrderResponse> getAllOrder(){
        return orderService.getAllOrder();
    }

    @GetMapping(path = "/{orderId}")
    public OrderResponse getOrder(@PathVariable("orderId") String orderId){
        return orderService.getOrder(orderId);
    }

    @PostMapping
    public OrderResponse addOrder(@RequestBody OrderRequest orderRequest){
        return orderService.addOrder(orderRequest);
    }



}

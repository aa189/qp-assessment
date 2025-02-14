package com.grocerymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.grocerymanagementsystem.model.Order;
import com.grocerymanagementsystem.model.OrderItem;
import com.grocerymanagementsystem.service.OrderService;

@RestController
@RequestMapping("/orders")
public class UserController {

    @Autowired
    private OrderService orderService;

    @PostMapping
    public Order placeOrder(@RequestParam Long userId, @RequestBody List<OrderItem> orderItems) {
        return orderService.placeOrder(userId, orderItems);
    }
}

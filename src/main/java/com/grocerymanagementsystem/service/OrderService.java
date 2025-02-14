package com.grocerymanagementsystem.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerymanagementsystem.model.Order;
import com.grocerymanagementsystem.model.OrderItem;
import com.grocerymanagementsystem.repository.OrderItemRepository;
import com.grocerymanagementsystem.repository.OrderRepository;

@Service
public class OrderService {
	
	@Autowired
	private OrderRepository orderRepository;

    @Autowired
    private OrderItemRepository orderItemRepository;

    public Order placeOrder(Long userId, List<OrderItem> orderItems) {
        Order order = new Order();
        order.setUserId(userId);
        order.setStatus("Placed");

        order = orderRepository.save(order);

        double totalPrice = 0.0;
        for (OrderItem orderItem : orderItems) {
            orderItem.setOrder(order);
            orderItemRepository.save(orderItem);
            totalPrice += orderItem.getPrice() * orderItem.getQuantity();
        }

        // Assuming Order price is set here for future updates
        return order;
    }
}

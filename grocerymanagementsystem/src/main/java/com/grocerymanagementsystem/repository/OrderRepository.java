package com.grocerymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grocerymanagementsystem.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

}

package com.grocerymanagementsystem.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.grocerymanagementsystem.model.GroceryItem;

public interface GroceryItemRepository extends JpaRepository<GroceryItem, Long> {
	
}

package com.grocerymanagementsystem.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.grocerymanagementsystem.model.GroceryItem;
import com.grocerymanagementsystem.repository.GroceryItemRepository;

@Service
public class GroceryItemService {

	@Autowired
    private GroceryItemRepository groceryItemRepository;

    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemRepository.findAll();
    }

    public Optional<GroceryItem> getGroceryItemById(Long id) {
        return groceryItemRepository.findById(id);
    }

    public GroceryItem addGroceryItem(GroceryItem groceryItem) {
        return groceryItemRepository.save(groceryItem);
    }

    public void removeGroceryItem(Long id) {
        groceryItemRepository.deleteById(id);
    }

    public GroceryItem updateGroceryItem(Long id, GroceryItem groceryItem) {
        if (groceryItemRepository.existsById(id)) {
            groceryItem.setId(id);
            return groceryItemRepository.save(groceryItem);
        }
        return null;
    }

    public GroceryItem updateInventory(Long id, int inventory) {
        Optional<GroceryItem> groceryItem = groceryItemRepository.findById(id);
        if (groceryItem.isPresent()) {
            groceryItem.get().setInventory(inventory);
            return groceryItemRepository.save(groceryItem.get());
        }
        return null;
    }
}

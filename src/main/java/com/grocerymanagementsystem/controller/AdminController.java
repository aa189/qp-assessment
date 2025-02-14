package com.grocerymanagementsystem.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.grocerymanagementsystem.model.GroceryItem;
import com.grocerymanagementsystem.service.GroceryItemService;

@RestController
@RequestMapping("/admin/grocery-items")
public class AdminController {

    @Autowired
    private GroceryItemService groceryItemService;

    @PostMapping
    public GroceryItem addGroceryItem(@RequestBody GroceryItem groceryItem) {
        return groceryItemService.addGroceryItem(groceryItem);
    }

    @GetMapping
    public List<GroceryItem> getAllGroceryItems() {
        return groceryItemService.getAllGroceryItems();
    }

    @DeleteMapping("/{id}")
    public String removeGroceryItem(@PathVariable Long id) {
        groceryItemService.removeGroceryItem(id);
        return "Grocery item deleted successfully";
    }

    @PutMapping("/{id}")
    public GroceryItem updateGroceryItem(@PathVariable Long id, @RequestBody GroceryItem groceryItem) {
        return groceryItemService.updateGroceryItem(id, groceryItem);
    }

    @PatchMapping("/{id}/inventory")
    public GroceryItem updateInventory(@PathVariable Long id, @RequestBody int inventory) {
        return groceryItemService.updateInventory(id, inventory);
    }
}
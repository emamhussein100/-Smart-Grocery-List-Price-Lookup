package org.example.smartgrocery.service;

import org.example.smartgrocery.dto.AddToListRequest;
import org.example.smartgrocery.dto.ShoppingItemForProduct;
import org.example.smartgrocery.dto.ShoppingListDto;
import org.example.smartgrocery.entity.Product;
import org.example.smartgrocery.entity.ShoppingList;
import org.example.smartgrocery.entity.User;

import java.util.List;

public interface ShoppingListService {
    ShoppingListDto createList(Long userId);
    ShoppingListDto addProduct(AddToListRequest addToListRequest);
    public List<ShoppingListDto> getUserLists(Long userId);
}

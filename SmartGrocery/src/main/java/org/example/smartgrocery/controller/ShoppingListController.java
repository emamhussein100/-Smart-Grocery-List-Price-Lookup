package org.example.smartgrocery.controller;

import org.example.smartgrocery.dto.AddToListRequest;
import org.example.smartgrocery.dto.ShoppingItemForProduct;
import org.example.smartgrocery.dto.ShoppingListDto;
import org.example.smartgrocery.service.ShoppingListService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController()
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/shoppingList")
public class ShoppingListController {
    private final ShoppingListService shoppingListService;

    @Autowired
    public ShoppingListController(ShoppingListService shoppingListService) {
        this.shoppingListService = shoppingListService;
    }
    @PostMapping("/create/{userId}")
    public ShoppingListDto createList(@PathVariable Long userId) {
        return shoppingListService.createList(userId);
    }
    @PostMapping("/addProduct")
    public ShoppingListDto addProduct(@RequestBody AddToListRequest addToListRequest) {
        return shoppingListService.addProduct(addToListRequest);
    }
    @GetMapping("/getUserLists/{userId}")
    public List<ShoppingListDto> getUserLists(@PathVariable Long userId) {
        return shoppingListService.getUserLists(userId);
    }


}

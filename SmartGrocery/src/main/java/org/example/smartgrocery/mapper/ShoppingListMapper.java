package org.example.smartgrocery.mapper;

import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.dto.ShoppingListDto;
import org.example.smartgrocery.dto.ShoppingListItemDto;
import org.example.smartgrocery.dto.UserDto;
import org.example.smartgrocery.entity.ShoppingList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Set;
import java.util.stream.Collectors;

@Service
public class ShoppingListMapper {

    private final ProductMapper productMapper;

    @Autowired
    public ShoppingListMapper(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }
    public ShoppingListDto toShoppingListDto(ShoppingList shoppingList) {
        ShoppingListDto dto = new ShoppingListDto();
        dto.setId(shoppingList.getId());

        UserDto userDto = new UserDto();
        userDto.setUserId(shoppingList.getUser().getId());
        userDto.setUsername(shoppingList.getUser().getUsername());
        userDto.setEmail(shoppingList.getUser().getEmail());
        userDto.setRole(shoppingList.getUser().getRole().toString());
        dto.setUser(userDto);

        Set<ShoppingListItemDto> items = shoppingList.getItems().stream().map(item -> {
            ShoppingListItemDto i = new ShoppingListItemDto();
            i.setId(item.getId());
            i.setQuantity(item.getQuantity());

            ProductDto p = new ProductDto();
            p.setId(item.getProduct().getId());
            p.setName(item.getProduct().getName());
            p.setCategory(item.getProduct().getCategory());
            p.setCalories(item.getProduct().getCalories());
            p.setBrand(item.getProduct().getBrand());
            p.setPrice(item.getProduct().getPrice());

            i.setProduct(p);
            return i;
        }).collect(Collectors.toSet());

        dto.setItems(items);

        return dto;
    }
}

package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ShoppingListItemDto {
    private Long id;
    private ProductDto product;
    private Integer quantity;
}

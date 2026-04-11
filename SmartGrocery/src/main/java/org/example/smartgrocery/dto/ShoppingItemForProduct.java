package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ShoppingItemForProduct {
    private Long listId;
    private Long productId;
}

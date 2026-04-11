package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.smartgrocery.entity.Product;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class ShoppingListDto {
    private Long id;
    private UserDto user;
    private Set<ShoppingListItemDto > items;
}

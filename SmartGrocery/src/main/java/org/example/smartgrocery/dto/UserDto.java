package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.example.smartgrocery.entity.ShoppingList;

import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    private Long userId;
    private String username;
    private String email;
    private String role;
}

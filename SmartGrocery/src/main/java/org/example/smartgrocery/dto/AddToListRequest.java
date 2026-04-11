package org.example.smartgrocery.dto;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class AddToListRequest {
    private Long userId;
    private Long listId;
    private Long productId;
    private Integer quantity;
}

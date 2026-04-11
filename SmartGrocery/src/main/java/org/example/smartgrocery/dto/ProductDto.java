package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import java.util.Set;


@Setter
@Getter
@NoArgsConstructor
@ToString
public class ProductDto {
    private Long id;
    private String name;
    private String category;
    private Double calories;
    private String brand;
    private Double price;
    private Boolean approved;
}

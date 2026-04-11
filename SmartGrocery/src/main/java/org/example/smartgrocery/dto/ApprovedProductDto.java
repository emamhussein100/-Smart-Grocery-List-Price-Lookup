package org.example.smartgrocery.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Setter
@Getter
@NoArgsConstructor
@ToString
public class ApprovedProductDto {
    private String name;
    private String category;
    private Double calories;
    private String brand;
    private Double price;
    private Boolean approved;
}

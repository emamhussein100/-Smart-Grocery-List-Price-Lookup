package org.example.smartgrocery.mapper;

import org.example.smartgrocery.dto.ApprovedProductDto;
import org.example.smartgrocery.dto.MealDto;
import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.entity.Product;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.stream.Collectors;

@Service
public class ProductMapper {

    public ProductDto toProductDto(Product product) {
        ProductDto productDto = new ProductDto();
        productDto.setId(product.getId());
        productDto.setName(product.getName());
        productDto.setCategory(product.getCategory());
        productDto.setCalories(product.getCalories());
        productDto.setBrand(product.getBrand());
        productDto.setPrice(product.getPrice());
        productDto.setApproved(product.getApproved());
        return productDto;
    }
    public Product toApprovedProduct(MealDto dto) {
        Product product = new Product();
        product.setId(Long.valueOf(dto.getIdMeal().toString()));
        product.setName(dto.getStrMeal());
        product.setCategory(dto.getStrCategory());
        product.setCalories(generateCalories());
        product.setBrand(dto.getStrArea());
        product.setPrice(generatePrice());
        product.setApproved(true);
        return product;
    }
    private Double generatePrice() {
        return 50 + (Math.random() * 15);
    }

    private Double generateCalories() {
        return 100 + (Math.random() * 40);
    }

}

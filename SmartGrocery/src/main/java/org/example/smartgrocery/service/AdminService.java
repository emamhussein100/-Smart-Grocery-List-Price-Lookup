package org.example.smartgrocery.service;
import org.example.smartgrocery.dto.MealDto;
import org.example.smartgrocery.dto.ProductDto;


import java.util.List;

public interface AdminService {

    List<MealDto> searchMeals(String query);

    List<ProductDto> bulkImport(List<MealDto> meals);

    ProductDto addApprovedProduct(MealDto dto);

    void deleteProduct(Long id);
}

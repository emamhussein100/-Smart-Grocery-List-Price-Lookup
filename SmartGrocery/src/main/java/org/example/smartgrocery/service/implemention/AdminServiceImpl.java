package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.MealDto;
import org.example.smartgrocery.dto.MealResponse;
import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.entity.Product;
import org.example.smartgrocery.mapper.ProductMapper;
import org.example.smartgrocery.repository.ProductRepository;
import org.example.smartgrocery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AdminServiceImpl implements AdminService {

    private final ExternalFoodApiClient apiClient;
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public AdminServiceImpl(ExternalFoodApiClient apiClient, ProductRepository productRepository, ProductMapper productMapper) {
        this.apiClient = apiClient;
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }
    public List<MealDto> searchMeals(String query) {
        MealResponse response = apiClient.searchMeals(query);

        if (response == null || response.getMeals() == null) {
            return new ArrayList<>();
        }

        return response.getMeals();
    }
    public List<ProductDto> bulkImport(List<MealDto> meals) {

        List<Product> products = meals.stream()
                .map(productMapper::toApprovedProduct)
                .collect(Collectors.toList());
        productRepository.saveAll(products);

        return products.stream()
                .map(productMapper::toProductDto)
                .collect(Collectors.toList());
    }

    public ProductDto addApprovedProduct(MealDto dto) {
        Product product = productMapper.toApprovedProduct(dto);
        productRepository.save(product);
        return productMapper.toProductDto(product);
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);
    }
}

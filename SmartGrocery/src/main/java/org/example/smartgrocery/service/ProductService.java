package org.example.smartgrocery.service;

import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ProductService {
    List<ProductDto> getApprovedProducts();
    List<ProductDto> search(String keyword);
    Page<ProductDto> getAll(Pageable pageable);
}

package org.example.smartgrocery.service.implemention;

import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.entity.Product;
import org.example.smartgrocery.mapper.ProductMapper;
import org.example.smartgrocery.repository.ProductRepository;
import org.example.smartgrocery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final ProductMapper productMapper;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, ProductMapper productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    @Override
    public List<ProductDto> getApprovedProducts() {
        List<Product> products = productRepository.findByApprovedTrue();
        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    public List<ProductDto> search(String keyword) {
        List<Product> products = productRepository.findByNameContainingIgnoreCaseAndApprovedTrue(keyword);
        return products.stream().map(productMapper::toProductDto).collect(Collectors.toList());
    }

    @Override
    public Page<ProductDto> getAll(Pageable pageable) {
        Page<Product> products = productRepository.findByApprovedTrue(pageable);
        return products.map(productMapper::toProductDto);
    }
}

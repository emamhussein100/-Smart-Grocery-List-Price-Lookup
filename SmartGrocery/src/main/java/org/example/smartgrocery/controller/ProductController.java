package org.example.smartgrocery.controller;

import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/all")
    public List<ProductDto> getAll() {
        return productService.getApprovedProducts();
    }

    @GetMapping("/search")
    public List<ProductDto> search(@RequestParam String keyword) {
        return productService.search(keyword);
    }
    @GetMapping("/all/page")
    public Page<ProductDto> getAll(Pageable pageable) {
        return productService.getAll(pageable);
    }
}
package org.example.smartgrocery.controller;

import org.example.smartgrocery.dto.ApprovedProductDto;
import org.example.smartgrocery.dto.MealDto;
import org.example.smartgrocery.dto.MealResponse;
import org.example.smartgrocery.dto.ProductDto;
import org.example.smartgrocery.entity.Product;
import org.example.smartgrocery.service.AdminService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/admin")
public class AdminController {

    private final AdminService adminService;

    @Autowired
    public AdminController(AdminService adminService) {
        this.adminService = adminService;
    }

    @GetMapping("/search")
    public List<MealDto> search(@RequestParam String query) {

        System.out.println("🔥 CONTROLLER HIT: " + query);

        List<MealDto> result = adminService.searchMeals(query);

        System.out.println("🔥 RESULT SIZE: " + result.size());

        return result;
    }

    @PostMapping("/products")
    public ProductDto addProduct(@RequestBody MealDto dto) {
        return adminService.addApprovedProduct(dto);
    }
    @PostMapping("/products/bulk")
    public List<ProductDto> bulkImport(@RequestBody List<MealDto> meals) {
        return adminService.bulkImport(meals);
    }
    @DeleteMapping("/products/{id}")
    public void delete(@PathVariable Long id) {
        adminService.deleteProduct(id);
    }
}

package org.example.smartgrocery.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.annotations.ColumnDefault;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "products")
public class Product {
    @Id
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "name")
    private String name;

    @Column(name = "category", length = 100)
    private String category;

    @Column(name = "calories")
    private Double calories;

    @Column(name = "brand", length = 100)
    private String brand;

    @Column(name = "price")
    private Double price;

    @ColumnDefault("false")
    @Column(name = "approved")
    private Boolean approved;

}
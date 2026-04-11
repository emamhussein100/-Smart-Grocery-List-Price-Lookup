package org.example.smartgrocery.repository;

import org.example.smartgrocery.entity.ShoppingList;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ShoppingListRepository extends JpaRepository<ShoppingList, Long> {
    @Query("SELECT DISTINCT s FROM ShoppingList s JOIN FETCH s.user u WHERE s.user.id = :userId")
    List<ShoppingList> findByUserId(@Param("userId") Long userId);
}

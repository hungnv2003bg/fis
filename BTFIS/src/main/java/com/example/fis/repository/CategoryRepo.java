package com.example.fis.repository;


import com.example.fis.entity.Category;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepo extends JpaRepository<Category, Long> {
    public boolean existsByNameCategoryContains(String nameCategory);
}

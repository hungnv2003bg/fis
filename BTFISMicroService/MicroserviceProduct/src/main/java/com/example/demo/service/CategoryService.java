package com.example.demo.service;


import com.example.demo.model.request.category.CategorySaveRequest;
import com.example.demo.model.request.category.CategoryUpdateRequest;
import com.example.demo.model.response.CategoryResponse;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories();

    List<CategoryResponse> delete(Long id);

    CategoryResponse saveCategory(CategorySaveRequest categorySaveRequest);

    CategoryResponse updateCategory(Long id, CategoryUpdateRequest categoryUpdateRequest);

    CategoryResponse getCategory(Long id);

}

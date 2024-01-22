package com.example.fis.service;

import com.example.fis.model.response.CategoryResponse;
import com.example.fis.model.request.category.CategorySaveRequest;
import com.example.fis.model.request.category.CategoryUpdateRequest;

import java.util.List;

public interface CategoryService {
    List<CategoryResponse> getCategories();

    List<CategoryResponse> delete(Long id);

    CategoryResponse saveCategory(CategorySaveRequest categorySaveRequest);

    CategoryResponse updateCategory(Long id, CategoryUpdateRequest categoryUpdateRequest);

    CategoryResponse getCategory(Long id);

}

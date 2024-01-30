package com.example.demo.mapper;

import com.example.demo.entity.Category;
import com.example.demo.model.request.category.CategorySaveRequest;
import com.example.demo.model.request.category.CategoryUpdateRequest;
import com.example.demo.model.response.CategoryResponse;
import org.springframework.stereotype.Component;

@Component
public class CategoryMapper {
    public Category toCategory(CategorySaveRequest categorySaveRequest) {
        Category category = new Category();
        category.setId(categorySaveRequest.getId());
        category.setCodeCategory(categorySaveRequest.getCodeCategory());
        category.setNameCategory(categorySaveRequest.getNameCategory());
        category.setCreateDate(categorySaveRequest.getCreateDate());
        return category;
    }

    public Category toCategory(CategoryUpdateRequest categoryUpdateRequest) {
        Category category = new Category();
        category.setNameCategory(categoryUpdateRequest.getNameCategory());
        category.setUpdateDate(categoryUpdateRequest.getUpdateDate());
        return category;
    }

    public CategoryResponse toCategoryReponse(Category Category) {
        CategoryResponse categoryResponse = new CategoryResponse();
        categoryResponse.setId(Category.getId());
        categoryResponse.setCodeCategory(Category.getCodeCategory());
        categoryResponse.setNameCategory(Category.getNameCategory());
        categoryResponse.setCreateDate(Category.getCreateDate());
        categoryResponse.setUpdateDate(Category.getUpdateDate());
        return categoryResponse;
    }
}

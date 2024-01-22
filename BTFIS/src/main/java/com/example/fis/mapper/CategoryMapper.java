package com.example.fis.mapper;

import com.example.fis.entity.Category;
import com.example.fis.model.response.CategoryResponse;
import com.example.fis.model.request.category.CategorySaveRequest;
import com.example.fis.model.request.category.CategoryUpdateRequest;
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

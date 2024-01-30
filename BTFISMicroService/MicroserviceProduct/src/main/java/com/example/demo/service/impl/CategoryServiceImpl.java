package com.example.demo.service.impl;


import com.example.demo.entity.Category;
import com.example.demo.exception.BusinessException;
import com.example.demo.exception.ErrorCode;
import com.example.demo.mapper.CategoryMapper;
import com.example.demo.model.request.category.CategorySaveRequest;
import com.example.demo.model.request.category.CategoryUpdateRequest;
import com.example.demo.model.response.CategoryResponse;
import com.example.demo.repository.CategoryRepo;
import com.example.demo.service.CategoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;


@Service
@AllArgsConstructor
public class CategoryServiceImpl implements CategoryService {
    private final CategoryMapper categoryMapper;

    private final CategoryRepo categoryRepo;

    @Override
    public List<CategoryResponse> getCategories() {
        List<Category> categories = categoryRepo.findAll();
        return categories.stream().map(categoryMapper::toCategoryReponse).toList();
    }

    @Override
    public List<CategoryResponse> delete(Long id) {
        Optional<Category> deletedCategory = categoryRepo.findById(id);
        if (deletedCategory.isEmpty()) {
            throw new BusinessException(ErrorCode.CATEGORY_NOT_FOUND);
        }
        categoryRepo.deleteById(id);
        return getCategories();
    }

    @Override
    public CategoryResponse saveCategory(CategorySaveRequest categorySaveRequest) {
        Category category = categoryMapper.toCategory(categorySaveRequest);
        if (categoryRepo.existsByNameCategoryContains(category.getNameCategory())){
            throw new BusinessException(ErrorCode.CATENAME_EXIST);
        }
        if (category.getNameCategory().equals("")) {
            throw new BusinessException(ErrorCode.CATENAME_NOT_BLANK);
        }
        category.setCreateDate(LocalDateTime.now());
        categoryRepo.save(category);
        category.setCodeCategory("Cate" + category.getId());
        categoryRepo.save(category);
        return categoryMapper.toCategoryReponse(category);
    }

    @Override
    public CategoryResponse updateCategory(Long id, CategoryUpdateRequest categoryUpdateRequest) {
        Optional<Category> categoryOptional = categoryRepo.findById(id);
        if (categoryOptional.isEmpty()) {
            throw new BusinessException(ErrorCode.CATEGORY_NOT_FOUND);
        }

        Category category = categoryOptional.get();
        Category updateCategory = categoryMapper.toCategory(categoryUpdateRequest);
        category.setNameCategory(updateCategory.getNameCategory());
        category.setUpdateDate(LocalDateTime.now());
        categoryRepo.save(category);
        return categoryMapper.toCategoryReponse(category);
    }

    @Override
    public CategoryResponse getCategory(Long id) {
        Category category = categoryRepo.findById(id)
                .orElseThrow(() -> new BusinessException(ErrorCode.CATEGORY_NOT_FOUND));
        return categoryMapper.toCategoryReponse(category);
    }

}

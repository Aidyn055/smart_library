package com.example.smartlibrary.service;

import com.example.smartlibrary.entity.Category;
import com.example.smartlibrary.exception.BusinessException;
import com.example.smartlibrary.exception.ResourceNotFoundException;
import com.example.smartlibrary.repository.CategoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class CategoryService {

    private final CategoryRepository categoryRepository;

    public List<Category> getAllCategories() {
        return categoryRepository.findAll();
    }

    public Category getCategoryById(Long id) {
        return categoryRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Category not found with id: " + id));
    }

    public Category createCategory(Category category) {
        try {
            if (categoryRepository.findByNameIgnoreCase(category.getName()).isPresent()) {
                throw new BusinessException("Category with this name already exists");
            }

            return categoryRepository.save(category);
        } catch (Exception e) {
            throw new RuntimeException("Error while creating category: " + e.getMessage());
        }
    }

    public Category updateCategory(Long id, Category updatedCategory) {
        try {
            Category existingCategory = getCategoryById(id);

            existingCategory.setName(updatedCategory.getName());

            return categoryRepository.save(existingCategory);
        } catch (Exception e) {
            throw new RuntimeException("Error while updating category: " + e.getMessage());
        }
    }

    public void deleteCategory(Long id) {
        try {
            Category category = getCategoryById(id);
            categoryRepository.delete(category);
        } catch (Exception e) {
            throw new RuntimeException("Error while deleting category: " + e.getMessage());
        }
    }
}

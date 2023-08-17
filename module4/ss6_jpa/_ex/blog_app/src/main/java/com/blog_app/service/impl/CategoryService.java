package com.blog_app.service.impl;

import com.blog_app.model.category.Category;
import com.blog_app.repository.ICategoryRepository;
import com.blog_app.service.ICategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;

    @Override
    public List<Category> showListCategory() {
        return categoryRepository.findAll();
    }

    @Override
    public Page<Category> showAllCategory(Pageable pageable) {
        return categoryRepository.findAll(pageable);
    }

    @Override
    public Category save(Category category) {
        return categoryRepository.save(category);
    }

    @Override
    public Category findById(int id) {
        return categoryRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(int id, Category category) {
        if (categoryRepository.findById(id)!=null) {
            categoryRepository.save(category);
            return true;
        }
        return false;
    }

    @Override
    public Category findByName(String name) {
        return categoryRepository.findByCategoryName(name);
    }

    @Override
    public boolean delete(int id) {
        if(categoryRepository.findById(id)!=null) {
            categoryRepository.deleteById(id);
            return true;
        }
        return false;
    }
}

package com.blog_app.service;

import com.blog_app.model.Category;
import com.blog_app.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class CategoryService implements ICategoryService {
    @Autowired
    private ICategoryRepository categoryRepository;
    @Override
    public List<Category> showAllCategory() {
        return categoryRepository.findAll();
    }
}

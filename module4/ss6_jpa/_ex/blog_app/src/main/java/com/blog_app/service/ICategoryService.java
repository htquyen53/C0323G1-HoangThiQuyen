package com.blog_app.service;

import com.blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICategoryService {
    List<Category> showListCategory();
    Page<Category> showAllCategory(Pageable pageable);
    Category findByName(String name);
    Category save(Category category);
    Category findById(int id);
    boolean update(int id, Category category);
    boolean delete(int id);

}

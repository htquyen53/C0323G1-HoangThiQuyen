package com.blog_app.service;

import com.blog_app.model.Category;

import java.util.List;

public interface ICategoryService {
    List<Category> showAllCategory();
    Category save(Category category);

}

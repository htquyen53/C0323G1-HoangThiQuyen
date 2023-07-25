package com.blog_app.service;

import com.blog_app.model.Blog;
import com.blog_app.model.Category;

import java.util.List;

public interface IBlogService {
    List<Blog> displayAll();
    List<Blog> searchTitle(String title);
    boolean save(Blog blog);
    Blog findById(int id);
    boolean update(int id, Blog blog);
    boolean deleteById(int Id);

}

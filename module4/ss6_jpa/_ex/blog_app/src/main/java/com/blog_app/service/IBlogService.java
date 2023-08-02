package com.blog_app.service;

import com.blog_app.model.Blog;
import com.blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Date;
import java.util.List;

public interface IBlogService {
    List<Blog> displayAll();
    List<Blog> searchTitle(String title);
    boolean save(Blog blog);
    Blog findById(int id);
    boolean update(int id, Blog blog);
    boolean deleteById(int id);
    Page<Blog> findAll(Pageable pageable, String name);
    Page<Blog> getBlogsByCategory(Pageable pageable, Category category);
    Page<Blog> sortByDatePost(Pageable pageable, Date date);
}

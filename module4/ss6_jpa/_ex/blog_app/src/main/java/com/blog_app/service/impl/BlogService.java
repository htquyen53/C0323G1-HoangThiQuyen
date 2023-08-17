package com.blog_app.service.impl;

import com.blog_app.model.blog.Blog;
import com.blog_app.model.category.Category;
import com.blog_app.repository.IBlogRepository;
import com.blog_app.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class BlogService implements IBlogService {
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> displayAll() {
        return blogRepository.findAll();
    }

    @Override
    public Page<Blog> findAll(Pageable pageable, String name) {
        return blogRepository.findBlogByTitleContaining(pageable,name);
    }

    @Override
    public List<Blog> searchTitle(String title) {
        return blogRepository.searchTitle(title);
    }

    @Override
    public boolean save(Blog blog) {
        Blog blog1 = blogRepository.save(blog);
        if (blog1 == null) {
            return false;
        }
        return true;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(int id, Blog blog) {
        if (findById(id) != null) {
           Blog blogUpdate =  blogRepository.save(blog);
            return true;
        }
        return false;

    }

    @Override
    public boolean deleteById(int id) {
       try {
           blogRepository.deleteById(id);
       } catch (Exception e) {
           return false;
       } return true;
    }

    @Override
    public Page<Blog> sortByDatePost(Pageable pageable, Date date) {
        return blogRepository.findAllByDatePost(pageable, date);
    }

    @Override
    public Page<Blog> getBlogsByCategory(Pageable pageable, Category category) {
        return blogRepository.findBlogsByCategory(pageable,category);
    }
}

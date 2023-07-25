package com.blog_app.service;

import com.blog_app.model.Blog;
import com.blog_app.model.Category;
import com.blog_app.repository.IBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogService implements IBlogService{
    @Autowired
    private IBlogRepository blogRepository;

    @Override
    public List<Blog> displayAll() {
        return blogRepository.findAll();
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
        } return true;
    }

    @Override
    public Blog findById(int id) {
        return blogRepository.findById(id).orElse(null);
    }

    @Override
    public boolean update(int id, Blog blog) {
        return false;
    }

    @Override
    public boolean deleteById(int Id) {
        return false;
    }
}

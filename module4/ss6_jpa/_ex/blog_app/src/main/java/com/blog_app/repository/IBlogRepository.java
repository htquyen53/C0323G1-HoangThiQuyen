package com.blog_app.repository;

import com.blog_app.model.Blog;
import com.blog_app.model.Category;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Date;
import java.util.List;

public interface IBlogRepository extends JpaRepository<Blog,Integer> {
    @Query(value = "select * from blog where name like :title", nativeQuery = true)
    List<Blog> searchTitle(@Param(value = "title")String name);
    Page<Blog> findBlogByTitleContaining(Pageable pageable, String name);
    Page<Blog> findAllByDatePost(Pageable pageable, Date date);
    Page<Blog> findBlogsByCategory(Pageable pageable, Category category);
}

package com.blog_app.repository;

import com.blog_app.model.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAuthorRepository extends JpaRepository<Author,Integer> {
}

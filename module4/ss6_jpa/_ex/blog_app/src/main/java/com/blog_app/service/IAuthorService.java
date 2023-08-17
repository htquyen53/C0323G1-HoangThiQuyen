package com.blog_app.service;

import com.blog_app.model.author.Author;

import java.util.List;

public interface IAuthorService {
    List<Author> authors();
    Author save (Author author);
    boolean delete(Author author);

}

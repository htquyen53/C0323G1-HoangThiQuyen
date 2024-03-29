package com.blog_app.service.impl;

import com.blog_app.model.author.Author;
import com.blog_app.repository.IAuthorRepository;
import com.blog_app.service.IAuthorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class AuthorService implements IAuthorService {
    @Autowired
    private IAuthorRepository authorRepository;
    @Override
    public List<Author> authors() {
        return authorRepository.findAll();
    }

    @Override
    public Author save(Author author) {
        return authorRepository.save(author);
    }

    @Override
    public boolean delete(Author author) {
        try {
            authorRepository.delete(author);
        } catch (Exception e) {
            return false;
        } return true;
    }
}

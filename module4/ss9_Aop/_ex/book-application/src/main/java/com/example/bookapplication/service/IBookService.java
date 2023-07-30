package com.example.bookapplication.service;

import com.example.bookapplication.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IBookService {
    Page<Book> showList(Pageable pageable, String name);
    boolean update(int id, Book book);
    Book findById(int id);
    long borrow(Book book);
}

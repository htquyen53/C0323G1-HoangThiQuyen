package com.example.bookapplication.service;

import com.example.bookapplication.model.Book;
import com.example.bookapplication.repository.IBookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Random;

@Service
public class BookService implements IBookService{
    @Autowired
    private IBookRepository bookRepository;

    @Override
    public Page<Book> showList(Pageable pageable, String name) {
        return bookRepository.findAllByTitleContaining(pageable, name);
    }

    @Override
    public long borrow (Book book) {
        book.setQuantity(book.getQuantity()-1);
        Random random = new Random();
        return random.nextInt(100000);
    }

    @Override
    public boolean update(int id, Book book) {
        if(bookRepository.findById(id)!= null) {
            bookRepository.save(book);
            return true;
        }
        return false;
    }

    @Override
    public Book findById(int id) {
        return bookRepository.findById(id).orElse(null);
    }
}

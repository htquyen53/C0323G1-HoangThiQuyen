package com.example.bookapplication.repository;

import com.example.bookapplication.model.Book;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IBookRepository extends JpaRepository<Book, Integer> {
    Page<Book> findAllByTitleContaining(Pageable pageable, String name);
}


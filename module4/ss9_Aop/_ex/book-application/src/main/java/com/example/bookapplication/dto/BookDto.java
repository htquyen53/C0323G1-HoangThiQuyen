package com.example.bookapplication.dto;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class BookDto implements Validator {
    private int id;
    private String title;
    private int quantity;
    private long code;

    public BookDto() {
    }

    public BookDto(int id, String title, int quantity, long code) {
        this.id = id;
        this.title = title;
        this.quantity = quantity;
        this.code = code;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public long getCode() {
        return code;
    }

    public void setCode(long code) {
        this.code = code;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        BookDto bookDto = (BookDto) target;
    }
}

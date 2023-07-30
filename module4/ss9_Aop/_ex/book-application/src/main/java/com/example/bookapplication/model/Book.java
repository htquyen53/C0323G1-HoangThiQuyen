package com.example.bookapplication.model;

public class Book {
    private int id;
    private String title;
    private int quantity;
    private long code;

    public Book() {
    }

    public Book(int id, String title, int quantity, long code) {
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
}

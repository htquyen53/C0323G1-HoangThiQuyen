package com.blog_app.model;

import javax.persistence.*;

@Entity
public class Summary {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String summaryPost;
    @OneToOne(mappedBy = "summary")
    private Blog blog;
}

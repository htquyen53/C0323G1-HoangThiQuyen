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

    public Summary(String summaryPost) {
        this.summaryPost = summaryPost;
    }

    public Summary() {
    }

    public Summary(int id, String summaryPost, Blog blog) {
        this.id = id;
        this.summaryPost = summaryPost;
        this.blog = blog;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getSummaryPost() {
        return summaryPost;
    }

    public void setSummaryPost(String summaryPost) {
        this.summaryPost = summaryPost;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    @Override
    public String toString() {
        return "Summary{" +
                "id=" + id +
                ", summaryPost='" + summaryPost + '\'' +
                ", blog=" + blog +
                '}';
    }
}

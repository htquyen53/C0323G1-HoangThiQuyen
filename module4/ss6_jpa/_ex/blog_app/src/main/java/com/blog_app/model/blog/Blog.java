package com.blog_app.model.blog;

import com.blog_app.model.author.Author;
import com.blog_app.model.category.Category;
import com.blog_app.model.summary.Summary;

import javax.persistence.*;
import java.sql.Date;

@Entity
public class Blog {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String content;
    private Date datePost;
    private String imgPath;

    @ManyToOne
    @JoinColumn(name = "id_author", referencedColumnName = "id")
    private Author author;

    @OneToOne
    @JoinColumn (name = "id_summary", referencedColumnName = "id")
    private Summary summary;

    @ManyToOne
    @JoinColumn(name = "id_category", referencedColumnName = "id")
    private Category category;

    public Blog() {
    }

    public Blog(int id, String title, String content, Date datePost, String imgPath) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.datePost = datePost;
        this.imgPath = imgPath;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Date getDatePost() {
        return datePost;
    }

    public void setDatePost(Date datePost) {
        this.datePost = datePost;
    }

    public String getImgPath() {
        return imgPath;
    }

    public void setImgPath(String imgPath) {
        this.imgPath = imgPath;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }

    public Summary getSummary() {
        return summary;
    }

    public void setSummary(Summary summary) {
        this.summary = summary;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}

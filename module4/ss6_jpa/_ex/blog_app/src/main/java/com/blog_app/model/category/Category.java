package com.blog_app.model.category;

import com.blog_app.model.blog.Blog;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Objects;
import java.util.Set;

@Entity
public class Category {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String categoryName;
    @OneToMany(mappedBy = "category")
    @JsonBackReference
    private Set<Blog> blog;

    public Category() {
    }

    public Category(int id, String categoryName) {
        this.id = id;
        this.categoryName = categoryName;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCategoryName() {
        return categoryName;
    }

    public void setCategoryName(String categoryName) {
        this.categoryName = categoryName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Category category = (Category) o;
        return id == category.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

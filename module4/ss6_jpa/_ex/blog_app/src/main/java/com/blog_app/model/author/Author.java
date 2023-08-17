package com.blog_app.model.author;

import com.blog_app.model.blog.Blog;
import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.sql.Date;
import java.util.Set;

@Entity
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String authorName;
    private Date birthday;
    private int citizenID;
    private int visaCard;
    @OneToMany(mappedBy = "author")
    @JsonBackReference
    private Set<Blog> blogSet;



    public Author() {
    }

    public Author(int id, String name, Date birthday, int citizenID, int visaCard) {
        this.id = id;
        this.authorName = name;
        this.birthday = birthday;
        this.citizenID = citizenID;
        this.visaCard = visaCard;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getAuthorName() {
        return authorName;
    }

    public void setAuthorName(String name) {
        this.authorName = name;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public int getCitizenID() {
        return citizenID;
    }

    public void setCitizenID(int citizenID) {
        this.citizenID = citizenID;
    }

    public int getVisaCard() {
        return visaCard;
    }

    public void setVisaCard(int visaCard) {
        this.visaCard = visaCard;
    }
}

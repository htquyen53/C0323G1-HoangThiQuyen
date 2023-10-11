package com.bugbugbuzz_be.model.user;

import javax.persistence.*;

@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String courseName;
    @Column(columnDefinition = "LONGTEXT")
    private String courseImage;
    @Column(columnDefinition = "LONGTEXT")
    private String coursePath;
    private Boolean isDeleted;
    @ManyToOne
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;

    public Course() {
    }

    public Course(Long id, String courseName, String courseImage, String coursePath, Boolean isDeleted, User user) {
        this.id = id;
        this.courseName = courseName;
        this.courseImage = courseImage;
        this.coursePath = coursePath;
        this.isDeleted = isDeleted;
        this.user = user;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    public String getCourseImage() {
        return courseImage;
    }

    public void setCourseImage(String courseImage) {
        this.courseImage = courseImage;
    }

    public String getCoursePath() {
        return coursePath;
    }

    public void setCoursePath(String coursePath) {
        this.coursePath = coursePath;
    }
    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

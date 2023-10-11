package com.bugbugbuzz_be.model.user;

import javax.persistence.*;
import java.util.Set;

@Entity
public class AcademicLevel {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nameLevel;
    private Boolean isDeleted;
    @OneToMany(mappedBy = "academicLevel")
    private Set<User> userSet;

    public AcademicLevel() {
    }

    public AcademicLevel(Integer id, String nameLevel, Boolean isDeleted, Set<User> userSet) {
        this.id = id;
        this.nameLevel = nameLevel;
        this.isDeleted = isDeleted;
        this.userSet = userSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNameLevel() {
        return nameLevel;
    }

    public void setNameLevel(String nameLevel) {
        this.nameLevel = nameLevel;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}

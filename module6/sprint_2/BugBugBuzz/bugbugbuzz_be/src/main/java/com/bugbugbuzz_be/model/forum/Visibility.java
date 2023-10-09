package com.bugbugbuzz_be.model.forum;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Visibility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private Boolean isDeleted;
    private String name;
    @OneToMany(mappedBy = "visibility")
    private Set<Post> postSet;

    public Visibility() {
    }

    public Visibility(Integer id, Boolean isDeleted, String name, Set<Post> postSet) {
        this.id = id;
        this.isDeleted = isDeleted;
        this.name = name;
        this.postSet = postSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Set<Post> getPostSet() {
        return postSet;
    }

    public void setPostSet(Set<Post> postSet) {
        this.postSet = postSet;
    }
}

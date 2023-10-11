package com.bugbugbuzz_be.model.forum;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Reaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Boolean isDeleted;
    @JsonBackReference
    @OneToMany(mappedBy = "reaction")
    private Set<PostReaction> postReactionSet;

    public Reaction() {
    }

    public Reaction(Integer id, String name, Boolean isDeleted, Set<PostReaction> postReactionSet) {
        this.id = id;
        this.name = name;
        this.isDeleted = isDeleted;
        this.postReactionSet = postReactionSet;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public Set<PostReaction> getPostReactionSet() {
        return postReactionSet;
    }

    public void setPostReactionSet(Set<PostReaction> postReactionSet) {
        this.postReactionSet = postReactionSet;
    }
}

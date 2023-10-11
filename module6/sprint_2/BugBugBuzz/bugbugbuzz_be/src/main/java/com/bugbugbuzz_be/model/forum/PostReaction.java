package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;

import javax.persistence.*;

@Entity
public class PostReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name="post_id", referencedColumnName = "id")
    private Post post;

    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    @ManyToOne
    @JoinColumn(name="reaction_id", referencedColumnName = "id")
    private Reaction reaction;

    public PostReaction() {
    }

    public PostReaction(Long id, Post post, AppUser appUser, Reaction reaction) {
        this.id = id;
        this.post = post;
        this.appUser = appUser;
        this.reaction = reaction;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Post getPost() {
        return post;
    }

    public void setPost(Post post) {
        this.post = post;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }
}

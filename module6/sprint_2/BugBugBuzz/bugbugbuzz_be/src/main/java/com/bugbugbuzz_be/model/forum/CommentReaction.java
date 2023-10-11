package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;

import javax.persistence.*;

@Entity
public class CommentReaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    @ManyToOne
    @JoinColumn(name = "comment_id", referencedColumnName = "id")
    private Comment comment;

    @ManyToOne
    @JoinColumn(name = "reaction_id", referencedColumnName = "id")
    private Reaction reaction;

    @ManyToOne
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;

    public CommentReaction() {
    }

    public CommentReaction(Integer id, Comment comment, Reaction reaction, AppUser appUser) {
        this.id = id;
        this.comment = comment;
        this.reaction = reaction;
        this.appUser = appUser;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Comment getComment() {
        return comment;
    }

    public void setComment(Comment comment) {
        this.comment = comment;
    }

    public Reaction getReaction() {
        return reaction;
    }

    public void setReaction(Reaction reaction) {
        this.reaction = reaction;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }
}

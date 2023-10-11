package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(columnDefinition = "timestamp")
    private String timePost;
    private Boolean isDeleted = false;
    @ManyToOne
    @JoinColumn(name="app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne
    @JoinColumn(name="visibility_id", referencedColumnName = "id")
    private Visibility visibility;
    @OneToMany(mappedBy = "post")
    private Set<Image> imageSet;
    @OneToMany(mappedBy = "post")
    private Set<PostReaction> postReactionSet;
    @OneToMany(mappedBy = "post")
    private Set<Comment> commentSet;

    public Post() {
    }

    public Post(Long id, String title, String content, String timePost, Boolean isDeleted, AppUser appUser, Visibility visibility, Set<Image> imageSet, Set<PostReaction> postReactionSet, Set<Comment> commentSet) {
        this.id = id;
        this.title = title;
        this.content = content;
        this.timePost = timePost;
        this.isDeleted = isDeleted;
        this.appUser = appUser;
        this.visibility = visibility;
        this.imageSet = imageSet;
        this.postReactionSet = postReactionSet;
        this.commentSet = commentSet;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
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

    public String getTimePost() {
        return timePost;
    }

    public void setTimePost(String timePost) {
        this.timePost = timePost;
    }

    public Boolean getDeleted() {
        return isDeleted;
    }

    public void setDeleted(Boolean deleted) {
        isDeleted = deleted;
    }

    public AppUser getAppUser() {
        return appUser;
    }

    public void setAppUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public Visibility getVisibility() {
        return visibility;
    }

    public void setVisibility(Visibility visibility) {
        this.visibility = visibility;
    }

    public Set<Image> getImageSet() {
        return imageSet;
    }

    public void setImageSet(Set<Image> imageSet) {
        this.imageSet = imageSet;
    }

    public Set<PostReaction> getPostReactionSet() {
        return postReactionSet;
    }

    public void setPostReactionSet(Set<PostReaction> postReactionSet) {
        this.postReactionSet = postReactionSet;
    }

    public Set<Comment> getCommentSet() {
        return commentSet;
    }

    public void setCommentSet(Set<Comment> commentSet) {
        this.commentSet = commentSet;
    }
}

package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;
import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;
import java.util.Map;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class Post {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String content;
    @Column(columnDefinition = "datetime")
    private String timePost;
    @Column(columnDefinition = "false")
    private Boolean isDeleted;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "app_user_id", referencedColumnName = "id")
    private AppUser appUser;
    @ManyToOne
    @JsonManagedReference
    @JoinColumn(name = "visibility_id", referencedColumnName = "id")
    private Visibility visibility;
    @JsonBackReference
    @OneToMany(mappedBy = "post")
    private Set<Image> imageSet;
    @JsonBackReference
    @OneToMany(mappedBy = "post")
    private Set<PostReaction> postReactionSet;
    @JsonBackReference
    @OneToMany(mappedBy = "post")
    private Set<Comment> commentSet;

}

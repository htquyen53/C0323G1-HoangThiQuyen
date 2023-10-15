package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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

}

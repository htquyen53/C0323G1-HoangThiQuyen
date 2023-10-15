package com.bugbugbuzz_be.model.forum;

import com.bugbugbuzz_be.model.app.AppUser;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;



@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
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
}

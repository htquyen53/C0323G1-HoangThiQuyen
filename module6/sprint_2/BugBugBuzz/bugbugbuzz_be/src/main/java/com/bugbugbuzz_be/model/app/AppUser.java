package com.bugbugbuzz_be.model.app;

import com.bugbugbuzz_be.model.forum.Comment;
import com.bugbugbuzz_be.model.forum.CommentReaction;
import com.bugbugbuzz_be.model.forum.Post;
import com.bugbugbuzz_be.model.forum.PostReaction;
import com.bugbugbuzz_be.model.payment.Payment;
import com.bugbugbuzz_be.model.token.Token;
import com.bugbugbuzz_be.model.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "app_user")
public class AppUser implements UserDetails {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String username;
    private String password;
    private boolean isDeleted;
    private boolean isActive;
    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name="user_id", referencedColumnName = "id")
    private User user;
    @OneToMany(mappedBy = "appUser")
    private List<Post> postList;
    @OneToMany(mappedBy = "comment")
    private List<Comment> comments;
    @OneToMany(mappedBy = "appUser")
    private List<PostReaction> postReactions;
    @OneToMany(mappedBy = "appUser")
    private List<Payment> payments;
    @OneToMany(mappedBy = "appUser")
    private List<CommentReaction> commentReactions;
    @ManyToMany(fetch = FetchType.EAGER)
    private Collection<AppRole> roles = new ArrayList<>();

    @OneToMany(mappedBy = "appUser")
    private List<Token> tokenList;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return roles.stream().map(role -> new SimpleGrantedAuthority(role.getName())).collect(Collectors.toList());
    }

    @Override
    public String getUsername() {
        return username;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return true;
    }
}

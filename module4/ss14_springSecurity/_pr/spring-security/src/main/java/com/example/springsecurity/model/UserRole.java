package com.example.springsecurity.model;

import javax.persistence.*;

@Entity
@Table(name = "user_role", uniqueConstraints = {
        @UniqueConstraint(name = "USER_ROLE_UK", columnNames = {"user_id", "role_id"})
})
public class UserRole {
    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    private Long id;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private AppUser appUser;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "role_id",nullable = false)
    private AppRole appRole;

    public UserRole() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppUser getUser() {
        return appUser;
    }

    public void setUser(AppUser appUser) {
        this.appUser = appUser;
    }

    public AppRole getRole() {
        return appRole;
    }

    public void setRole(AppRole appRole) {
        this.appRole = appRole;
    }
}

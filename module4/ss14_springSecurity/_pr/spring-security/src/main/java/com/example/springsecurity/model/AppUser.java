package com.example.springsecurity.model;

import org.springframework.security.core.GrantedAuthority;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "user",uniqueConstraints = {
        @UniqueConstraint(name = "USER_UK",columnNames = "user_name")
})
public class AppUser {
    @Id
    @GeneratedValue
    @Column(name = "user_id",nullable = false)
    private Long userId;
    @Column(name = "user_name",length = 36,nullable = false)
    private String userName;

    @Column(name = "encrypted_password",length = 128,nullable = false)
    private String encryptedPassword;

    @Column(name = "enabled",length = 1,nullable = false)
    private boolean enabled;

    public AppUser() {
    }

    public AppUser(String userName, String encryptedPassword, List<GrantedAuthority> grantList) {
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getEncryptedPassword() {
        return encryptedPassword;
    }

    public void setEncryptedPassword(String encryptedPassword) {
        this.encryptedPassword = encryptedPassword;
    }

    public boolean isEnabled() {
        return enabled;
    }

    public void setEnabled(boolean enabled) {
        this.enabled = enabled;
    }
}

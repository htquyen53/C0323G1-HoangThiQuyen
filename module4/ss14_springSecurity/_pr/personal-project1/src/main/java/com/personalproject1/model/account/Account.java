package com.personalproject1.model.account;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.personalproject1.model.user.User;

import javax.persistence.*;

@Entity
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String accountName;
    private String accountPassword;
    @ManyToOne
    @JsonBackReference
    @JoinColumn(name = "role_id",referencedColumnName = "role_id")
    private Role role;

    @OneToOne(mappedBy = "account")
    private User user;

    public Account() {
    }

    public Account(String accountName, String accountPassword, Role role, User user) {
        this.accountName = accountName;
        this.accountPassword = accountPassword;
        this.role = role;
        this.user = user;
    }

    public String getAccountName() {
        return accountName;
    }

    public void setAccountName(String accountName) {
        this.accountName = accountName;
    }

    public String getAccountPassword() {
        return accountPassword;
    }

    public void setAccountPassword(String accountPassword) {
        this.accountPassword = accountPassword;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}

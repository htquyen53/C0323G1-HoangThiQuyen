package com.personalproject1.model.account;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer roleId;
    private String roleName;
    @OneToMany(mappedBy = "role")
    private Set<Account> accountSet;

    public Role() {
    }

    public Role(Integer roleId, String roleName, Set<Account> accountSet) {
        this.roleId = roleId;
        this.roleName = roleName;
        this.accountSet = accountSet;
    }

    public Integer getRoleId() {
        return roleId;
    }

    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    public String getRoleName() {
        return roleName;
    }

    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }

    public Set<Account> getAccountSet() {
        return accountSet;
    }

    public void setAccountSet(Set<Account> accountSet) {
        this.accountSet = accountSet;
    }
}

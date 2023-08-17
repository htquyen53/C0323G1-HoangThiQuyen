package com.personalproject1.model.user;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class EmployeeType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer employeeTypeId;
    private String employeeTypeName;
    @JsonBackReference
    @OneToMany(mappedBy = "employeeType")
    private Set<User> userSet;

    public EmployeeType() {
    }

    public EmployeeType(Integer employeeTypeId, String employeeTypeName, Set<User> userSet) {
        this.employeeTypeId = employeeTypeId;
        this.employeeTypeName = employeeTypeName;
        this.userSet = userSet;
    }

    public Integer getEmployeeTypeId() {
        return employeeTypeId;
    }

    public void setEmployeeTypeId(Integer employeeTypeId) {
        this.employeeTypeId = employeeTypeId;
    }

    public String getEmployeeTypeName() {
        return employeeTypeName;
    }

    public void setEmployeeTypeName(String employeeTypeName) {
        this.employeeTypeName = employeeTypeName;
    }

    public Set<User> getUserSet() {
        return userSet;
    }

    public void setUserSet(Set<User> userSet) {
        this.userSet = userSet;
    }
}


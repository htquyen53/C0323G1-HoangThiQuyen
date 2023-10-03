package com.example.test.model;

import javax.persistence.*;
import java.util.Set;

@Entity
public class GymRoom {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(columnDefinition = "varchar(20)", unique = true, nullable = false)
    private String code;

    @Column(columnDefinition = "varchar(255)", unique = true, nullable = false)
    private String name;
    @Column(columnDefinition = "date")
    private String startDate;
    private String address;
    @OneToMany(mappedBy = "gymRoom")
    private Set<Employee> employeeSet;

    @OneToMany(mappedBy = "gymRoom")
    private Set<Customer> customerSet;
    private Boolean flagDeleted = false;

    public GymRoom() {
    }

    public GymRoom(Long id, String code, String name, String startDate, String address, Set<Employee> employeeSet, Set<Customer> customerSet, Boolean flagDeleted) {
        this.id = id;
        this.code = code;
        this.name = name;
        this.startDate = startDate;
        this.address = address;
        this.employeeSet = employeeSet;
        this.customerSet = customerSet;
        this.flagDeleted = flagDeleted;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStartDate() {
        return startDate;
    }

    public void setStartDate(String startDate) {
        this.startDate = startDate;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Set<Employee> getEmployeeSet() {
        return employeeSet;
    }

    public void setEmployeeSet(Set<Employee> employeeSet) {
        this.employeeSet = employeeSet;
    }

    public Set<Customer> getCustomerSet() {
        return customerSet;
    }

    public void setCustomerSet(Set<Customer> customerSet) {
        this.customerSet = customerSet;
    }

    public Boolean getFlagDeleted() {
        return flagDeleted;
    }

    public void setFlagDeleted(Boolean flagDeleted) {
        this.flagDeleted = flagDeleted;
    }
}
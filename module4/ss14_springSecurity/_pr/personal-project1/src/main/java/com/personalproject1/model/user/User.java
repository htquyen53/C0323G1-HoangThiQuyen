package com.personalproject1.model.user;

import com.personalproject1.model.account.Account;

import javax.persistence.*;
import java.util.Date;

@Entity
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer userId;
    private String userName;
    private Boolean userGender;
    private Date userBirthday;
    private String userNumberPhone;
    private String userEmail;
    private String userIdCard;
    private Double userSalary;
    private String userAddress;
    private String userImgPath;
    @ManyToOne
    @JoinColumn(name = "employee_type_id",referencedColumnName = "employee_type_id")
    private EmployeeType employeeType;
    @OneToOne
    @JoinColumn(name = "account_name", referencedColumnName = "account_name",unique = true, nullable = false)
    private Account account;

    public User() {
    }

    public User(Integer userId, String userName, Boolean userGender, Date userBirthday, String userNumberPhone, String userEmail, String userIdCard, Double userSalary, String userAddress, String userImgPath, EmployeeType employeeType, Account account) {
        this.userId = userId;
        this.userName = userName;
        this.userGender = userGender;
        this.userBirthday = userBirthday;
        this.userNumberPhone = userNumberPhone;
        this.userEmail = userEmail;
        this.userIdCard = userIdCard;
        this.userSalary = userSalary;
        this.userAddress = userAddress;
        this.userImgPath = userImgPath;
        this.employeeType = employeeType;
        this.account = account;
    }

    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Boolean getUserGender() {
        return userGender;
    }

    public void setUserGender(Boolean userGender) {
        this.userGender = userGender;
    }

    public Date getUserBirthday() {
        return userBirthday;
    }

    public void setUserBirthday(Date userBirthday) {
        this.userBirthday = userBirthday;
    }

    public String getUserNumberPhone() {
        return userNumberPhone;
    }

    public void setUserNumberPhone(String userNumberPhone) {
        this.userNumberPhone = userNumberPhone;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getUserIdCard() {
        return userIdCard;
    }

    public void setUserIdCard(String userIdCard) {
        this.userIdCard = userIdCard;
    }

    public Double getUserSalary() {
        return userSalary;
    }

    public void setUserSalary(Double userSalary) {
        this.userSalary = userSalary;
    }

    public String getUserAddress() {
        return userAddress;
    }

    public void setUserAddress(String userAddress) {
        this.userAddress = userAddress;
    }

    public String getUserImgPath() {
        return userImgPath;
    }

    public void setUserImgPath(String userImgPath) {
        this.userImgPath = userImgPath;
    }

    public EmployeeType getEmployeeType() {
        return employeeType;
    }

    public void setEmployeeType(EmployeeType employeeType) {
        this.employeeType = employeeType;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }
}

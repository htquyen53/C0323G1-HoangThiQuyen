package com.personalproject1.dto;

import com.personalproject1.model.account.Account;
import com.personalproject1.model.user.EmployeeType;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class UserDto implements Validator {
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
    private EmployeeType employeeType;
    private Account account;

    public UserDto() {
    }

    public UserDto(Integer userId, String userName, Boolean userGender, Date userBirthday, String userNumberPhone, String userEmail, String userIdCard, Double userSalary, String userAddress, String userImgPath, EmployeeType employeeType, Account account) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

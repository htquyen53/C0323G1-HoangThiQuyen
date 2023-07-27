package com.validate_form.dto;

import com.validate_form.common.ValidateInput;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.Date;

public class UserDto implements Validator {
    private int id;
    private String firstName;
    private String lastName;
    private String phoneNumber;
    private Date birthday;
    private String email;

    public UserDto() {
    }

    public UserDto(int id, String firstName, String lastName, String phoneNumber, Date birthday, String email) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
        this.birthday = birthday;
        this.email = email;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public Date getBirthday() {
        return birthday;
    }

    public void setBirthday(Date birthday) {
        this.birthday = birthday;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        // Check name
        if (userDto.getFirstName().trim().equals("")) {
            errors.rejectValue("firstName", null, "Not empty!");
        } else if (userDto.getFirstName().length() < 5 || userDto.getFirstName().length() > 45) {
            errors.rejectValue("firstName", null, "Not valid length!");
        }
        if (userDto.getLastName().equals("")) {
            errors.rejectValue("lastName", null, "Not empty!");
        } else if (userDto.getLastName().length() < 5 || userDto.getLastName().length() > 45) {
            errors.rejectValue("lastName", null, "Not valid length!");
        }
        // check phoneNumber
        if (userDto.getPhoneNumber().equals("")) {
            errors.rejectValue("phoneNumber", null, "Not empty!");
        } else if (!userDto.getPhoneNumber().matches("^(0)[0-9]{8}$")) {
            errors.rejectValue("phoneNumber",null, "Not match regex!");
        }
        // check age
        if(userDto.getBirthday() == null) {
            errors.rejectValue("birthday", null, "Not empty!");
        } else if (!ValidateInput.checkAge(userDto.getBirthday())) {
            errors.rejectValue("birthday", null, "Not enough 18 years old!");
        }
        if (userDto.getEmail().trim().equals("")) {
            errors.rejectValue("email", null, "Not empty!");
        } else if (!userDto.getEmail().matches("^[a-z0-9]+@[a-z]+\\.[a-z]{2,3}$")) {
            errors.rejectValue("email", null, "Not match regex!");
        }
    }
}

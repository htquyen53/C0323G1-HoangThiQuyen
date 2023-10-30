package com.bugbugbuzz_be.dto;

import com.bugbugbuzz_be.model.app.AppRole;
import com.bugbugbuzz_be.model.token.Token;
import com.bugbugbuzz_be.model.user.AcademicLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import java.util.ArrayList;
import java.util.Collection;
import java.util.stream.Collectors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class UserDto implements Validator {
    private String username;
    private String password;
    private String name;
    private String birthday;
    private String email;
    private String phoneNumber;
    private String address;
    private String citizenId;
    private String career;
    private String biography;
    private AcademicLevel academicLevel;
    private Collection<AppRole> roles = new ArrayList<>();
    private static final String NAME_DTO = "name";
    private static final String BIRTHDAY_DTO = "birthday";
    private static final String ADDRESS_DTO = "address";
    private static final String PHONE_DTO = "phoneNumber";
    private static final String EMAIL_DTO = "email";
    private static final String NOTE_DTO = "note";
    private static final String NAME_REGEX = "^[a-zA-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễếệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ ]*$";
    private static final String BIRTHDAY_REGEX = "^\\d{4}-(0[1-9]|1[0-2])-(0[1-9]|[12][0-9]|3[01])$";
    private static final String PHONE_REGEX = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@[A-Za-z0-9.-]+$";
    private static final String CODE_REGEX = "^KH\\d+$";

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        UserDto userDto = (UserDto) target;
        // Check name
        if (userDto.getName() == null) {
            errors.rejectValue(NAME_DTO, "", "Please add your name!");
        } else if (userDto.getName().trim().equals("")) {
            errors.rejectValue(NAME_DTO, "", "Name cannot be empty! ");
        } else if (userDto.getName().length() < 2) {
            errors.rejectValue(NAME_DTO, "", "The entered name is not long enough!");
        } else if (userDto.getName().length() > 50) {
            errors.rejectValue(NAME_DTO, "", "The entered name is too long!");
        } else if (!userDto.getName().matches(NAME_REGEX)) {
            errors.rejectValue(NAME_DTO, "", "Name cannot contain special characters!");
        }

        // Check address
        if (userDto.getAddress() == null) {
            errors.rejectValue(ADDRESS_DTO, "", "Please provide the your address. ");
        } else if (userDto.getAddress().trim().equals("")) {
            errors.rejectValue(ADDRESS_DTO, "", "Address cannot be empty!");
        } else if (userDto.getAddress().length() < 5) {
            errors.rejectValue(ADDRESS_DTO, "", "The entered address is not long enough!");
        } else if (userDto.getAddress().length() > 100) {
            errors.rejectValue(ADDRESS_DTO, "", "The entered address is too long");
        }
        // Check birthday
        if (userDto.getBirthday() == null) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Please provide the your birthday!");
        } else if (userDto.getBirthday().trim().equals("")) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Birthday cannot be empty!");
        } else if (!userDto.getBirthday().matches(BIRTHDAY_REGEX)) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Entered wrong format date!");
        } else if (!FormatUserInfo.isDateValidAndBeforeCurrent(userDto.getBirthday())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Exceeds actual time!");
        } else if (!FormatUserInfo.check18YearsOld(userDto.getBirthday())) {
            errors.rejectValue(BIRTHDAY_DTO, "", "Warning: under 18 years old !");
        }

        // Check number phone
        if (userDto.getPhoneNumber() == null) {
            errors.rejectValue(PHONE_DTO, "", "Please provide the your number phone!");
        } else if (userDto.getPhoneNumber().trim().equals("")) {
            errors.rejectValue(PHONE_DTO, "", "Number phone cannot be empty!");
        } else if (userDto.getPhoneNumber().length() < 10) {
            errors.rejectValue(PHONE_DTO, "", "The entered address is not long enough! ");
        } else if (userDto.getPhoneNumber().length() > 11) {
            errors.rejectValue(PHONE_DTO, "", "The entered number phone is too long");
        } else if (!userDto.getPhoneNumber().matches(PHONE_REGEX)) {
            errors.rejectValue(PHONE_DTO, "", "Entered wrong format date!");
        }

        // Check email
        if (userDto.getEmail() == null) {
            errors.rejectValue(EMAIL_DTO, "", "Please provide the your email!");
        } else if (userDto.getEmail().trim().equals("")) {
            errors.rejectValue(EMAIL_DTO, "", "Email cannot be empty!");
        } else if (userDto.getEmail().length() > 50) {
            errors.rejectValue(EMAIL_DTO, "", "Email is too long!");
        } else if (!userDto.getEmail().matches(EMAIL_REGEX)) {
            errors.rejectValue(EMAIL_DTO, "", "Your entered is wrong format!");
        }

    }
}

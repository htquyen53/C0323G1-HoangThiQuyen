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
public class UserDto implements Validator{
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {

    }
}

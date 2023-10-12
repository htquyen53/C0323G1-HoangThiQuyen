package com.bugbugbuzz_be.auth;

import com.bugbugbuzz_be.model.user.AcademicLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class RegisterRequest {
    private String name;
    private String username;
    private String password;
    private String email;
    private List<String> roles;
    private String birthday;
    private String phoneNumber;
    private String address;
    private String citizenId;
    private String career;
    private String biography;
    private AcademicLevel academicLevel;
}

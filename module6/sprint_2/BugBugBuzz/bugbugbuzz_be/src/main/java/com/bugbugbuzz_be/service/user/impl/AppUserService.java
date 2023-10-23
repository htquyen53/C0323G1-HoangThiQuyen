package com.bugbugbuzz_be.service.user.impl;

import com.bugbugbuzz_be.dto.UserDto;
import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.user.User;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import com.bugbugbuzz_be.repository.user.IUserRepository;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@RequiredArgsConstructor
public class AppUserService implements IAppUserService {
    private final IAppUserRepository appUserRepository;
    private final IUserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    @Transactional
    public AppUser registerUser(UserDto userDto) {
        User newUser = User.builder()
                .name(userDto.getName())
                .birthday(userDto.getBirthday())
                .email(userDto.getEmail())
                .phoneNumber(userDto.getPhoneNumber())
                .address(userDto.getAddress())
                .citizenId(userDto.getCitizenId())
                .career(userDto.getCareer())
                .academicLevel(userDto.getAcademicLevel())
                .biography(userDto.getBiography())
                .build();
        userRepository.save(newUser);
        AppUser newAppUser = AppUser.builder()
                .username(userDto.getUsername())
                .password(passwordEncoder.encode(userDto.getPassword()))
                .user(newUser)
                .build();
        return appUserRepository.save(newAppUser);
    }

    @Override
    public AppUser  getAppUserByUsername(String username) {
        return appUserRepository.findAppUserByUsername(username).orElse(null);
    }
}

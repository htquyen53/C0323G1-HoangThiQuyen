package com.bugbugbuzz_be.auth;

import com.bugbugbuzz_be.config.JwtService;
import com.bugbugbuzz_be.dto.UserDto;
import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.token.Token;
import com.bugbugbuzz_be.model.token.TokenType;
import com.bugbugbuzz_be.repository.token.TokenRepository;
import com.bugbugbuzz_be.repository.user.IAppRoleRepository;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import com.bugbugbuzz_be.service.user.IAppUserService;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Collections;
import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private final IAppUserRepository appUserRepository;
    private final IAppRoleRepository appRoleRepository;
    private final IAppUserService appUserService;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
        // Kiểm tra ngời dùng có tồn tại hay chưa
        if (appUserRepository.findByUserName(registerRequest.getUsername()).isPresent()) {
            return AuthenticationResponse.builder()
                    .accessToken(null)
                    .errMsg("Existed username")
                    .build();
        }
        // Nếu người dùng không tồn tại thì tạo người dùng mới dựa trên thông tin request
        UserDto user = UserDto.builder()
                .name(registerRequest.getName())
                .username(registerRequest.getUsername())
                .password(passwordEncoder.encode(registerRequest.getPassword()))
                .birthday(registerRequest.getBirthday())
                .email(registerRequest.getEmail())
                .phoneNumber(registerRequest.getPhoneNumber())
                .citizenId(registerRequest.getCitizenId())
                .career(registerRequest.getCareer())
                .academicLevel(registerRequest.getAcademicLevel())
                .address(registerRequest.getAddress())
                .biography(registerRequest.getBiography())
                .roles(Collections.singletonList(appRoleRepository.findByName(registerRequest.getRoles().get(0))))
                .build();
        // Lưu người dùng vào DB
        AppUser savedUser = appUserService.registerUser(user);
        // Tạo mã token cho ngời dùng
        String jwtToken = jwtService.generateToken(savedUser);
        String refreshToken = jwtService.generateRefreshToken(savedUser);
        saveUserToken(savedUser,jwtToken);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        try {
            Authentication authenticator = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(authenticationRequest.getUsername(), authenticationRequest.getPassword()));
            if (authenticator.isAuthenticated()) {
                AppUser appUser = appUserRepository.findByUserName(authenticationRequest.getUsername()).orElseThrow(()-> new UsernameNotFoundException("User not found!"));
                System.out.println("------------- username is: "+ appUser.getUsername());
                String jwtToken = jwtService.generateToken(appUser);
                String refreshToken = jwtService.generateRefreshToken(appUser);
                System.out.println("----------------" + jwtToken);
                revokeAllUserTokens(appUser);
                saveUserToken(appUser, jwtToken);
                return AuthenticationResponse.builder()
                        .accessToken(jwtToken)
                        .refreshToken(refreshToken)
                        .build();
            } else {
                System.out.println("Xác thực thất bại!");
            }
        } catch (AuthenticationException e) {
            System.out.println("Ngoại lệ");
        } return AuthenticationResponse.builder().errMsg("Err").build();
    }
    private void saveUserToken(AppUser appUser, String jwtToken) {
        Token token = Token.builder()
                .appUser(appUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeAllUserTokens(AppUser appUser) {
        List<Token> validUserTokens = tokenRepository.findAllValidTokenByAppUser(appUser.getId());
        if (validUserTokens.isEmpty())
            return;
        validUserTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validUserTokens);
    }
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        Cookie[] cookies = request.getCookies();
        String refreshToken = null;
        final String username;
        if (cookies == null) {
            return;
        } else {
            for (Cookie cookie : cookies) {
                if (cookie.getName().equals("refreshToken")) {
                    refreshToken = cookie.getValue();
                    break;
                }
            }
        }
        if (refreshToken == null) {
            return;
        }
        username = jwtService.extractUsername(refreshToken); //extract username
        if (username != null) {
            AppUser appUser = this.appUserRepository.findByUserName(username).orElseThrow(()-> new UsernameNotFoundException("User not found!"));
            if (jwtService.isTokenValid(refreshToken, appUser)) {
                String accessToken = jwtService.generateToken(appUser);

                System.out.println("_______________Revoke___________");
                saveUserToken(appUser, accessToken);
                Cookie refreshTokenCookie = new Cookie("refreshToken", refreshToken);
                refreshTokenCookie.setMaxAge(7 * 24 * 60 * 60); // Set the cookie's maximum age in seconds (e.g., 7 days)
                refreshTokenCookie.setPath("/"); // Set the cookie's path
                refreshTokenCookie.setHttpOnly(true);
                response.addCookie(refreshTokenCookie);
                AuthenticationResponse authResponse = AuthenticationResponse.builder()
                        .accessToken(accessToken)
                        .refreshToken("At cookie")
                        .errMsg("Refresh successfully")
                        .build();
                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }
        }
    }
}

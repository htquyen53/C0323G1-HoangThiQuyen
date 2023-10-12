package com.bugbugbuzz_be.auth;

import com.bugbugbuzz_be.config.JwtService;
import com.bugbugbuzz_be.dto.UserDto;
import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.token.Token;
import com.bugbugbuzz_be.model.token.TokenType;
import com.bugbugbuzz_be.model.user.User;
import com.bugbugbuzz_be.repository.token.TokenRepository;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class AuthenticationService {
    private IAppUserRepository appUserRepository;
    private final TokenRepository tokenRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationResponse register(RegisterRequest registerRequest) {
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
                .build();

        String jwtToken = jwtService.generateToken(user);
        String refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder()
                .accessToken(jwtToken)
                .refreshToken(refreshToken)
                .build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest authenticationRequest) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(
                        authenticationRequest.getUsername(),
                        authenticationRequest.getPassword()
                )
        );
        AppUser appUser = appUserRepository.findByUserName(authenticationRequest.getUsername());
        String jwtToken = jwtService.generateToken(appUser);
        String refreshToken = jwtService.generateRefreshToken(appUser);
        revokeAllUserTokens(appUser);
        saveUserToken(appUser, jwtToken);
        return null;
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
}

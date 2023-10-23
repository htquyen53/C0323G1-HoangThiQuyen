package com.bugbugbuzz_be.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:3000")
@RequiredArgsConstructor
@EnableTransactionManagement
public class AuthenticationController {
 private final AuthenticationService authenticationService;
 @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request) {
     AuthenticationResponse response = authenticationService.register(request);
     if(response.getErrMsg()!=null){
         return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
     } return ResponseEntity.ok(response);
 }
    @PostMapping("/login-by-username")
    public ResponseEntity<AuthenticationResponse> loginByAccount(@RequestBody AuthenticationRequest request,
                                                                            HttpServletResponse response) {
        AuthenticationResponse authenticationResponse = authenticationService.authenticate(request);
        // Set refreshToken as a cookie in the response
        Cookie refreshTokenCookie = new Cookie("refreshToken", authenticationResponse.getRefreshToken());
        // Set the cookie's maximum age in seconds (e.g., 7 days)
        refreshTokenCookie.setMaxAge(7 * 24 * 60 * 60);
        // Set the cookie's path
        refreshTokenCookie.setPath("/");
        refreshTokenCookie.setHttpOnly(true);
        response.addCookie(refreshTokenCookie);

        authenticationResponse.setRefreshToken("At cookie");

        if (authenticationResponse.getErrMsg() == null) {
            return ResponseEntity.ok(authenticationResponse);
        } else if (authenticationResponse.getErrMsg().equals("Login failed!")) {
            return ResponseEntity.status(HttpStatus.CONFLICT).build();
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
    @PostMapping("/refresh-token")
    public void refreshToken(
            HttpServletRequest request,
            HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request,response);
    }
}

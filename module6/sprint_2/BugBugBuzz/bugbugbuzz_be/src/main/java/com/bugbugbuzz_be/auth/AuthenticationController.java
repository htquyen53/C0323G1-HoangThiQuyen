package com.bugbugbuzz_be.auth;

import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/auth")
@CrossOrigin(origins = "http://localhost:8080")
@RequiredArgsConstructor
public class AuthenticationController {
 private final AuthenticationService authenticationService;
 @PostMapping("/register")
    public ResponseEntity<AuthenticationResponse> register (@RequestBody RegisterRequest request) {
     AuthenticationResponse response = authenticationService.register(request);
     if(response.getErrMsg()!=null){
         return ResponseEntity.status(HttpStatus.CONFLICT).body(response);
     } return ResponseEntity.ok(response);
 }
}

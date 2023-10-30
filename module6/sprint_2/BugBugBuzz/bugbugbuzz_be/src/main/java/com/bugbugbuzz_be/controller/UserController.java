package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/user")
@CrossOrigin("*")
@RequiredArgsConstructor
public class UserController {
    private final IAppUserService appUserService;

    @GetMapping("/get-avatar")
    public ResponseEntity<?> getAccount(@RequestParam String username) {
        var avatar = appUserService.getAppUserByUsername(username).getAvatar();
        if (avatar != null) {
            return ResponseEntity.ok(avatar);
        } else {
            return ResponseEntity.noContent().build();
        }
    }

    @GetMapping("/home/get-avatar")
    public ResponseEntity<?> getAccountByUser(@RequestParam String username) {
        String avatar = appUserService.getAppUserByUsername(username).getAvatar();
        if (avatar != null) {
            return ResponseEntity.ok(avatar);
        } else {
            return ResponseEntity.noContent().build();
        }
    }


    @GetMapping("/check-vip")
    public ResponseEntity<?> checkVipStatus(@RequestParam String username) {
        String vipStatus = appUserService.checkVipStatusByUsername(username);
        if (vipStatus != null) {
            return ResponseEntity.ok(vipStatus);
        }
        return ResponseEntity.noContent().build();
    }
}

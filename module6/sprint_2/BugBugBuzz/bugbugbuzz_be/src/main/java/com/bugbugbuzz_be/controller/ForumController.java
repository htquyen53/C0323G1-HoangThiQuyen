package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.forum.Comment;
import com.bugbugbuzz_be.model.forum.CommentRequest;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.simp.SimpMessagingTemplate;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
@RequiredArgsConstructor
public class ForumController {
    private final IAppUserService appUserService;
   private final SimpMessagingTemplate simpMessagingTemplate;
    @MessageMapping("/post/{id}")
    public CommentRequest doComment(@Payload CommentRequest request) {
        AppUser requestAppUser = appUserService.getAppUserByUsername(request.getUsername());
        request.setTimeComment(new Date().toString());
        request.setAvatarImg(requestAppUser.getAvatar());
        simpMessagingTemplate.convertAndSend("/forum/posts/" + request.getPostId().toString(), request);
        return request;
    }
}

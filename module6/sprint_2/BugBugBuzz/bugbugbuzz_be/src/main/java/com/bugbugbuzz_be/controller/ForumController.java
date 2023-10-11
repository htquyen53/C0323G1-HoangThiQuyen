package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.forum.Post;
import org.springframework.messaging.handler.annotation.MessageMapping;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.messaging.handler.annotation.SendTo;
import org.springframework.stereotype.Controller;

import java.util.Date;

@Controller
public class ForumController {
    @MessageMapping("/post")
    @SendTo("/forum/posts")
    public Post doPost(@Payload Post post) {
        System.out.println(post.getTitle());
        post.setTimePost(new Date().toString());
        return post;
    }

}

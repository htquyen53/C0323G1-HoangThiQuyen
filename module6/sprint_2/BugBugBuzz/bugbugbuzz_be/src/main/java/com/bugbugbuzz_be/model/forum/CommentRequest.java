package com.bugbugbuzz_be.model.forum;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@AllArgsConstructor
@RequiredArgsConstructor
@Setter
@Getter
public class CommentRequest {
//    private Long id;
    private Long postId;
    private String commentContent;
    private String username;
    private  String avatarImg;
    private String timeComment;

}

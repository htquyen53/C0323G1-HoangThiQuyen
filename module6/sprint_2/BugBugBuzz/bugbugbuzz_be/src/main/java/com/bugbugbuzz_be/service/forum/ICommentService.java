package com.bugbugbuzz_be.service.forum;

import com.bugbugbuzz_be.model.forum.Comment;
import com.bugbugbuzz_be.model.forum.CommentRequest;

import java.util.List;

public interface ICommentService {
    List<Comment> getAllComments();
    Comment saveComment (CommentRequest request);
}

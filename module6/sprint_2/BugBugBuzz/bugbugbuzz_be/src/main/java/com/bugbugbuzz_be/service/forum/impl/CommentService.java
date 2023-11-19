package com.bugbugbuzz_be.service.forum.impl;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.forum.Comment;
import com.bugbugbuzz_be.model.forum.CommentRequest;
import com.bugbugbuzz_be.model.forum.Post;
import com.bugbugbuzz_be.repository.forum.ICommentRepository;
import com.bugbugbuzz_be.repository.forum.IPostRepository;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import com.bugbugbuzz_be.service.forum.ICommentService;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService implements ICommentService {
    private final ICommentRepository commentRepository;
    private final IAppUserRepository appUserRepository;
    private final IPostRepository postRepository;
    @Override
    public List<Comment> getAllComments() {
        return commentRepository.findAll();
    }

    @Override
    public Comment saveComment(CommentRequest request) {
        Optional<AppUser> appUser = appUserRepository.findAppUserByUsername(request.getUsername());
        Optional<Post> post = postRepository.findById(request.getPostId());
        LocalDateTime currentDate = LocalDateTime.now();
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDate.format(formatter);
        var savedComment = Comment.builder()
                .comment(request.getCommentContent())
                .appUser(appUser.get())
                .post(post.get())
                .timeComment(formattedDateTime)
                .build();
        return commentRepository.save(savedComment);
    }
}

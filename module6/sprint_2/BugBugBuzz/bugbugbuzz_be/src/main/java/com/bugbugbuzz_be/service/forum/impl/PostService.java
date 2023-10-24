package com.bugbugbuzz_be.service.forum.impl;

import com.bugbugbuzz_be.model.app.AppUser;
import com.bugbugbuzz_be.model.forum.Post;
import com.bugbugbuzz_be.model.forum.PostRequest;
import com.bugbugbuzz_be.model.forum.Visibility;
import com.bugbugbuzz_be.repository.forum.IPostRepository;
import com.bugbugbuzz_be.repository.forum.IVisibilityRepository;
import com.bugbugbuzz_be.repository.user.IAppUserRepository;
import com.bugbugbuzz_be.service.forum.IPostService;
import com.bugbugbuzz_be.service.user.IAppUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PostService implements IPostService {
    private  final IAppUserRepository appUserRepository;
    private final IPostRepository postRepository;
    private final IVisibilityRepository visibilityRepository;
    @Override
    public Page<Post> getAll(Pageable pageable) {
        return postRepository.findAll(pageable);
    }

    @Override
    @Transactional
    public Post savePost(PostRequest request) {
        Optional<Visibility> visibilityStatus = visibilityRepository.findById(request.getVisibilityId());
        Optional<AppUser> app = appUserRepository.findAppUserByUsername(request.getUsername());
        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println(currentDateTime);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        String formattedDateTime = currentDateTime.format(formatter);
        System.out.println(formattedDateTime);
        var newPost = Post.builder()
                .isDeleted(false)
                .title(request.getTitle())
                .content(request.getContent())
                .timePost(formattedDateTime)
                .visibility(visibilityStatus.get())
                .appUser(app.get())
                .build();
        return postRepository.save(newPost);
    }

}

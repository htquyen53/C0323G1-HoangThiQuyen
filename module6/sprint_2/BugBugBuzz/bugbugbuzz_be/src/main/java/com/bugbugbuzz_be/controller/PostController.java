package com.bugbugbuzz_be.controller;

import com.bugbugbuzz_be.model.forum.Post;
import com.bugbugbuzz_be.model.forum.PostRequest;
import com.bugbugbuzz_be.service.forum.IPostService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@CrossOrigin("*")
@RequestMapping("/api/post")
public class PostController {
    private final IPostService postService;

    @GetMapping("/home/list")
    public ResponseEntity<Page<Post>> getAll(@RequestParam(defaultValue = "0", required = false) Integer page,
                                             @RequestParam(defaultValue = "5", required = false) Integer postsPerPage) {
        Pageable pageable = PageRequest.of(page, postsPerPage, Sort.by("timePost").descending());
        Page<Post> postPage = postService.getAll(pageable);
        if (postPage.getTotalElements() > 0) {
            return ResponseEntity.ok(postPage);
        }
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/create")
    public ResponseEntity<?> savePost(@RequestBody PostRequest request) {
        Post savedPost = postService.savePost(request);
        if (savedPost != null) {
            return ResponseEntity.ok(savedPost);
        }
        return ResponseEntity.noContent().build();
    }

}

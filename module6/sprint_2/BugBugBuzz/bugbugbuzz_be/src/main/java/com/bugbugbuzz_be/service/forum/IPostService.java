package com.bugbugbuzz_be.service.forum;

import com.bugbugbuzz_be.model.forum.Post;
import com.bugbugbuzz_be.model.forum.PostRequest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IPostService {
    Page<Post> getAll(Pageable pageable);
    Post savePost(PostRequest request);
}

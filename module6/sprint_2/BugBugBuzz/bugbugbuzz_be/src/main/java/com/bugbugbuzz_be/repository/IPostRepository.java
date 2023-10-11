package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.forum.Post;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IPostRepository extends JpaRepository<Post, Long> {

}

package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.forum.Comment;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICommentRepository extends JpaRepository<Comment, Long> {

}

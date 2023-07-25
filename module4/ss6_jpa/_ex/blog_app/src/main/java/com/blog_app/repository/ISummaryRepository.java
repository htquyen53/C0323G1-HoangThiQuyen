package com.blog_app.repository;

import com.blog_app.model.Summary;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ISummaryRepository extends JpaRepository<Summary,Integer> {
}

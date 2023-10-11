package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.user.Course;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ICourseRepository extends JpaRepository<Course, Long> {
}

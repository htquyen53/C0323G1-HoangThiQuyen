package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.user.AcademicLevel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAcademicLevelRepository extends JpaRepository<AcademicLevel, Integer> {
}

package com.bugbugbuzz_be.repository.forum;

import com.bugbugbuzz_be.model.forum.Visibility;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IVisibilityRepository extends JpaRepository<Visibility, Integer> {
}

package com.bugbugbuzz_be.repository.forum;

import com.bugbugbuzz_be.model.forum.Reaction;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IReactionRepository extends JpaRepository<Reaction, Integer> {

}
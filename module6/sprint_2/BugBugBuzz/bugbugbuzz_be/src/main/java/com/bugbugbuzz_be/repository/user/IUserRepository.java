package com.bugbugbuzz_be.repository.user;

import com.bugbugbuzz_be.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IUserRepository extends JpaRepository<User, Long> {
}
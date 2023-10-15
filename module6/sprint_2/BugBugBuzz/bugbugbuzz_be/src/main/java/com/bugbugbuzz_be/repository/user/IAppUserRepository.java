package com.bugbugbuzz_be.repository.user;

import com.bugbugbuzz_be.model.app.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findByUserName(String userName);
}

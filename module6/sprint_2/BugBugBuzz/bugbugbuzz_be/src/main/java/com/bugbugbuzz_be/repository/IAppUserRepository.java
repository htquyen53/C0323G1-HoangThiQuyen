package com.bugbugbuzz_be.repository;

import com.bugbugbuzz_be.model.app.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {

}

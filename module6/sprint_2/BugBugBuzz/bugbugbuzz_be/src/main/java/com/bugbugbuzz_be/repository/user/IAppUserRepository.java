package com.bugbugbuzz_be.repository.user;

import com.bugbugbuzz_be.model.app.AppUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.Optional;

public interface IAppUserRepository extends JpaRepository<AppUser, Long> {
    Optional<AppUser> findAppUserByUsername(String userName);
    @Query(value = " select  p.name  from package p inner join payment pa on p.id = pa.package_id inner join app_user ap on pa.app_user_id = ap.id where ap.username = :username and pa.status = true ", nativeQuery = true)
    String checkVipByUsername (@Param("username") String username);
}

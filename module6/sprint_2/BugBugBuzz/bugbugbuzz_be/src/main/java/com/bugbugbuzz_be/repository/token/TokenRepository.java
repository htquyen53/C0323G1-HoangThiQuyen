package com.bugbugbuzz_be.repository.token;

import com.bugbugbuzz_be.model.token.Token;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    @Query(value = " select t from Token t inner join AppUser au on t.appUser.id = au.id where au.id = :id and (t.expired = false or t.revoked = false) " )
    List<Token> findAllValidTokenByAppUser(Long id);

    Optional<Token> findAllByToken(String token);
}

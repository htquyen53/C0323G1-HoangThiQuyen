package com.bugbugbuzz_be.repository.user;

import com.bugbugbuzz_be.model.app.AppRole;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IAppRoleRepository extends JpaRepository<AppRole, Integer> {
    AppRole findByName(String roleName);
}

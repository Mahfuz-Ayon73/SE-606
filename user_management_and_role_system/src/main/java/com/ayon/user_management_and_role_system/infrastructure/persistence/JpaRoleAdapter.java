package com.ayon.user_management_and_role_system.infrastructure.persistence;

import com.ayon.user_management_and_role_system.application.interfaces.RoleRepository;
import com.ayon.user_management_and_role_system.domain.Role;
import java.util.*;

public class JpaRoleAdapter implements RoleRepository {
    private final RoleJpaRepository repo;

    public JpaRoleAdapter(RoleJpaRepository repo) {
        this.repo = repo;
    }

    public UUID save(Role role) {
        RoleJpaEntity entity = new RoleJpaEntity(role.getId(), role.getRoleName());
        return repo.save(entity).getId();
    }

    public Optional<Role> findById(UUID id) {
        return repo.findById(id).map(r -> new Role(r.getId(), r.getRoleName()));
    }
}

package com.ayon.user_management_and_role_system.application.interfaces;

import com.ayon.user_management_and_role_system.domain.Role;

import java.util.Optional;
import java.util.UUID;

public interface RoleRepository {
    UUID save(Role role);
    Optional<Role> findById(UUID id);
}

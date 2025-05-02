package com.ayon.user_management_and_role_system.application.interfaces;

import com.ayon.user_management_and_role_system.domain.User;

import java.util.Optional;
import java.util.UUID;

public interface UserRepository {
    UUID save(User user);
    Optional<User> findById(UUID id);
    public void assignRole(UUID userId, UUID roleId);
}

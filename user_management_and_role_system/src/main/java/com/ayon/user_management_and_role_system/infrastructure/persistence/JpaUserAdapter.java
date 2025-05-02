package com.ayon.user_management_and_role_system.infrastructure.persistence;

import com.ayon.user_management_and_role_system.application.interfaces.UserRepository;
import com.ayon.user_management_and_role_system.domain.User;

import java.util.Optional;
import java.util.UUID;

public class JpaUserAdapter implements UserRepository {
    private final UserJpaRepository userRepo;
    private final RoleJpaRepository roleRepo;

    public JpaUserAdapter(UserJpaRepository userRepo, RoleJpaRepository roleRepo) {
        this.userRepo = userRepo;
        this.roleRepo = roleRepo;
    }

    @Override
    public UUID save(User user) {
        UserJpaEntity entity = new UserJpaEntity(user.getId(), user.getName(), user.getEmail());
        return userRepo.save(entity).getId();
    }

    @Override
    public Optional<User> findById(UUID id) {
        return userRepo.findById(id).map(u -> new User( u.getEmail(),u.getId(), u.getName()));
    }

    @Override
    public void assignRole(UUID userId, UUID roleId) {
        var user = userRepo.findById(userId).orElseThrow();
        var role = roleRepo.findById(roleId).orElseThrow();
        user.getRoles().add(role);
        userRepo.save(user);
    }
}

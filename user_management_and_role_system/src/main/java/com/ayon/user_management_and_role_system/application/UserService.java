package com.ayon.user_management_and_role_system.application;

import com.ayon.user_management_and_role_system.application.interfaces.RoleRepository;
import com.ayon.user_management_and_role_system.application.interfaces.UserRepository;
import com.ayon.user_management_and_role_system.domain.User;

import java.util.UUID;

public class UserService {
     private UserRepository userRepository;
     private RoleRepository roleRepository;

    public UserService(UserRepository userRepository, RoleRepository roleRepository) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    public UUID createUser(String name, String email) {
        User user = new User(email,UUID.randomUUID(), name);
        return userRepository.save(user);
    }

    public void assignRoleToUser(UUID userId, UUID roleId) {
        userRepository.assignRole(userId, roleId);
    }

    public User getUserWithRoles(UUID userId) {
        return userRepository.findById(userId).orElseThrow(() -> new RuntimeException("User not found"));
    }
}

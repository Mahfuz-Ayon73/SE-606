package com.ayon.user_management_and_role_system.application;

import com.ayon.user_management_and_role_system.application.interfaces.RoleRepository;
import com.ayon.user_management_and_role_system.domain.Role;

import java.util.UUID;

public class RoleService {
    private RoleRepository roleRepository;

    public RoleService(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    public UUID createRole(String roleName) {
        Role role = new Role(UUID.randomUUID(), roleName);
        return roleRepository.save(role);
    }



}

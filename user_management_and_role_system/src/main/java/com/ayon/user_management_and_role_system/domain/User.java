package com.ayon.user_management_and_role_system.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

public class User {
    private UUID id;
    private String name;
    private String email;
    private List<Role> roles = new ArrayList<>();

    public User(String email, UUID id, String name) {
        this.email = email;
        this.id = id;
        this.name = name;
    }

    public UUID getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getEmail() {
        return email;
    }

    public void assignRole(Role role) {
        if (!roles.contains(role)) roles.add(role);
    }
}

package com.ayon.user_management_and_role_system.infrastructure.controller;

import com.ayon.user_management_and_role_system.application.UserService;
import com.ayon.user_management_and_role_system.domain.User;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/users")
public class UserController {
    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public UUID createUser(@RequestBody Map<String, String> req) {
        return userService.createUser(req.get("name"), req.get("email"));
    }

    @PostMapping("/{userId}/assign-role/{roleId}")
    public String assignRole(@PathVariable UUID userId, @PathVariable UUID roleId) {
        userService.assignRoleToUser(userId, roleId);
        return "Role assigned";
    }

    @GetMapping("/{id}")
    public User getUser(@PathVariable UUID id) {
        return userService.getUserWithRoles(id);
    }
}

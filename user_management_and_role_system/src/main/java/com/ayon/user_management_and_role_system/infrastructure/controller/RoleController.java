package com.ayon.user_management_and_role_system.infrastructure.controller;
import com.ayon.user_management_and_role_system.application.RoleService;
import org.springframework.web.bind.annotation.*;
import java.util.*;

@RestController
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @PostMapping
    public UUID createRole(@RequestBody Map<String, String> req) {
        return roleService.createRole(req.get("roleName"));
    }
}

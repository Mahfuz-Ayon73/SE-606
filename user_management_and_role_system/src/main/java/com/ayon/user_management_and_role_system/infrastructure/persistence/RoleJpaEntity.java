package com.ayon.user_management_and_role_system.infrastructure.persistence;
import jakarta.persistence.*;
import java.util.*;

@Entity
public class RoleJpaEntity {
    @Id
    private UUID id;
    private String roleName;

    public RoleJpaEntity() {}

    public RoleJpaEntity(UUID id, String roleName) {
        this.id = id;
        this.roleName = roleName;
    }
    public UUID getId() {
        return id;
    }
    public void setId(UUID id) {
        this.id = id;
    }
    public String getRoleName() {
        return roleName;
    }
    public void setRoleName(String roleName) {
        this.roleName = roleName;
    }
}

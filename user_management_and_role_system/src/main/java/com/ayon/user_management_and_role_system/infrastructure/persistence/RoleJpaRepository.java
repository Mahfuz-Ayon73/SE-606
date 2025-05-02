package com.ayon.user_management_and_role_system.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface RoleJpaRepository extends JpaRepository<RoleJpaEntity, UUID> {
}

package com.ayon.user_management_and_role_system.infrastructure.persistence;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.*;

public interface UserJpaRepository extends JpaRepository<UserJpaEntity, UUID> {
}

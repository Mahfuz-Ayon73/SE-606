package com.ayon.user_management_and_role_system.config;

import com.ayon.user_management_and_role_system.application.RoleService;
import com.ayon.user_management_and_role_system.application.UserService;
import com.ayon.user_management_and_role_system.application.interfaces.RoleRepository;
import com.ayon.user_management_and_role_system.application.interfaces.UserRepository;
import com.ayon.user_management_and_role_system.infrastructure.persistence.JpaRoleAdapter;
import com.ayon.user_management_and_role_system.infrastructure.persistence.JpaUserAdapter;
import com.ayon.user_management_and_role_system.infrastructure.persistence.RoleJpaRepository;
import com.ayon.user_management_and_role_system.infrastructure.persistence.UserJpaRepository;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public UserService userService(UserRepository userRepository, RoleRepository roleRepository) {
        return new UserService(userRepository, roleRepository);
    }

    @Bean
    public RoleService roleService(RoleRepository roleRepository) {
        return new RoleService(roleRepository);
    }

    @Bean
    public UserRepository userRepository(UserJpaRepository userJpaRepository, RoleJpaRepository roleJpaRepository) {
        return new JpaUserAdapter(userJpaRepository, roleJpaRepository);
    }

    @Bean
    public RoleRepository roleRepository(RoleJpaRepository roleJpaRepository) {
        return new JpaRoleAdapter(roleJpaRepository);
    }
}

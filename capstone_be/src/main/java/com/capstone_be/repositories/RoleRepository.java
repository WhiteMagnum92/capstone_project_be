package com.capstone_be.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone_be.entities.ERole;
import com.capstone_be.entities.Role;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    
	Optional<Role> findByRoleName(ERole roleName);

}

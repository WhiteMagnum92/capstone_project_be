package com.capstone_be.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Privilegio;

public interface PrivilegioRepository extends JpaRepository<Privilegio, Integer> {
	
	Optional<Privilegio> findByName(String name);

}

package com.capstone_be.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.User;

public interface PersonaggioRepository extends JpaRepository<Personaggio, Integer> {

	Optional<Personaggio> findByName(String name);
	List<Personaggio> findByUser(User u);
	
	
}

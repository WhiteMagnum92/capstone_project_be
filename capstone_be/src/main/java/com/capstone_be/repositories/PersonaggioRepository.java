package com.capstone_be.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot_SpringSecurity.entity.User;

import com.capstone_be.entities.Personaggio;

public interface PersonaggioRepository extends JpaRepository<Personaggio, Integer> {

	Optional<Personaggio> findByName(String nome);
	List<Personaggio> findByUser(User u);
	
	
}
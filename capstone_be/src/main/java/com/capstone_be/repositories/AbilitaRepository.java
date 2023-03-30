package com.capstone_be.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone_be.entities.Abilita;

public interface AbilitaRepository extends JpaRepository<Abilita, Integer> {
	
	Optional<Abilita> findByName(String nome);

}

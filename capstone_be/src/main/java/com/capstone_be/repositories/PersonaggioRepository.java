package com.capstone_be.repositories;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.User;

public interface PersonaggioRepository extends JpaRepository<Personaggio, Integer> {

	Optional<Personaggio> findByName(String name);
	List<Personaggio> findByUser(User utentePreso);
	@Modifying
	@Query("DELETE FROM Personaggio p WHERE p.name = ?1 AND p.user.id = ?2")
	void deletePersonaggio(String nomePersonaggio, Long userId);
	
	
}

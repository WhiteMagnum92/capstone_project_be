package com.capstone_be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoot_SpringSecurity.entity.User;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.repositories.PersonaggioRepository;
import com.capstone_be.repositories.PrivilegioRepository;

import jakarta.persistence.EntityNotFoundException;

public class PersonaggioService {
	
	@Autowired
	private PersonaggioRepository repo;
	
	// read
	public List<Personaggio> getAll() {
		return repo.findAll();
	}

	public Personaggio getById(Integer id) {
		return repo.findById(id)
				.orElseThrow(() -> new EntityNotFoundException("Personaggio non trovato!!!"));
	}

	public Personaggio findByName(String nome) {
		return repo.findByName(nome)
				.orElseThrow(() -> new EntityNotFoundException("Personaggio non trovato!!!"));
		
	}
	public List<Personaggio> findByUser(User u) {
		return repo.findByUser(u);
				
	}

}
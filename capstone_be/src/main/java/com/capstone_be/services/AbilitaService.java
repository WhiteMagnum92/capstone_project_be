package com.capstone_be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone_be.entities.Abilita;
import com.capstone_be.repositories.AbilitaRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class AbilitaService {
	
	
		@Autowired
		private AbilitaRepository repo;
		
		// read
		public List<Abilita> getAll() {
			return repo.findAll();
		}

		public Abilita getById(Integer id) {
			return repo.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Abilita non trovata!!!"));
		}

		public Abilita findByName(String nome) {
			return repo.findByName(nome)
					.orElseThrow(() -> new EntityNotFoundException("Abilita non trovata!!!"));
			
		}

		
		
		 
		

	}


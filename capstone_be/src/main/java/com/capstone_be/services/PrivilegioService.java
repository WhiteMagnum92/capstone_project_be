package com.capstone_be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.repositories.AbilitaRepository;
import com.capstone_be.repositories.PrivilegioRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class PrivilegioService {
	
	
		@Autowired
		private PrivilegioRepository repo;
		
		// read
		public List<Privilegio> getAll() {
			return repo.findAll();
		}

		public Privilegio getById(Integer id) {
			return repo.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Privilegio non trovato!!!"));
		}

		public Privilegio findByName(String nome) {
			return repo.findByName(nome)
					.orElseThrow(() -> new EntityNotFoundException("Privilegio non trovato!!!"));
			
		}

		
		
		 
		

	}


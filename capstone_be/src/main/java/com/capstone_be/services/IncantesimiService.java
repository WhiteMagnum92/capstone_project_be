package com.capstone_be.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.repositories.AbilitaRepository;
import com.capstone_be.repositories.IncantesimiRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class IncantesimiService {
	
	
		@Autowired
		private IncantesimiRepository repo;
		
		// read
		public List<Incantesimo> getAll() {
			return repo.findAll();
		}

		public Incantesimo getById(Integer id) {
			return repo.findById(id)
					.orElseThrow(() -> new EntityNotFoundException("Abilita non trovata!!!"));
		}

		public List<Incantesimo> getByLvl(Integer id) {
			return repo.findByLvl(id);
		}
		
		
		 
		

	}


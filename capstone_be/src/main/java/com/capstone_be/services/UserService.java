package com.capstone_be.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.capstone_be.entities.User;
import com.capstone_be.repositories.UserRepository;

import jakarta.persistence.EntityNotFoundException;

@Service
public class UserService {

	@Autowired
	UserRepository repo;

	public User create(User s) {
		repo.save(s);
		return s;
	}

	// crea tutti
	public void creaAll(List<User> list) {
		repo.saveAll(list);
	}

	// get by id
	public User getbyId(Long id) {
		return repo.findById(id).orElseThrow(() -> new EntityNotFoundException("L'utente con questo id non esiste!"));
	}

	// put
	public User put(User s) {
		repo.save(s);
		return s;
	}

	// delete
	public User deleteById(Long id) {
		User u = getbyId(id);
		repo.deleteById(id);
		return u;
	}

	// delete
	public User deleteByUsername(String username) {
		Optional<User> u = repo.findByUsername(username);
		if (u.isPresent()) {
			repo.deleteById(u.get().getId());
			return u.get();
		}
		else
			return null;
	}

	// filtra per email
	public Optional<User> cercaTramiteEmail(String email) {
		Optional<User> userFiltratoPerNome = repo.findByEmail(email);
		return userFiltratoPerNome;
	}

	// filtra per username
	public Optional<User> cercaTramiteUsername(String username) {
		Optional<User> userFiltratoPerNome = repo.findByUsername(username);
		return userFiltratoPerNome;
	}
}

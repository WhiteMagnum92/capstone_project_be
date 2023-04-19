package com.capstone_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.User;
import com.capstone_be.services.PersonaggioService;
import com.capstone_be.services.UserService;

@RestController
@CrossOrigin(origins = "*", maxAge = 3600)
@RequestMapping("api/user")
public class UserController {

	@Autowired
	UserService userService;
	@Autowired
	PersonaggioService personaggioService;

	// prendere i personaggi da username
	@GetMapping("/personaggi/{username}")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<List<Personaggio>> getPersonaggiUser(@PathVariable String username) {

		Optional<User> oUtentePreso = userService.cercaTramiteUsername(username);
		if (oUtentePreso.isPresent()) {
			List<Personaggio> personaggiPresi = personaggioService.findByUser(oUtentePreso.get());

			return new ResponseEntity<>(personaggiPresi, HttpStatus.OK);
		} else
			return new ResponseEntity<>(null, HttpStatus.OK);
	}

	// cerca per username
	@GetMapping("/username/{username}")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<Optional<User>> getUserbyUsername(@PathVariable String username) {
		return new ResponseEntity<>(userService.cercaTramiteUsername(username), HttpStatus.OK);
	}

	// delete
	@DeleteMapping("/delete/{username}")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<User> deleteUser(@PathVariable String username) {
		return new ResponseEntity<>(userService.deleteByUsername(username), HttpStatus.OK);
	}

}

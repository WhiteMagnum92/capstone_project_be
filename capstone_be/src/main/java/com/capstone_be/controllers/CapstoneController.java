package com.capstone_be.controllers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.services.PersonaggioService;

@RestController
@RequestMapping("/api")
public class CapstoneController {
	
	private PersonaggioService personaggioService;
	public CapstoneController(PersonaggioService personaggioService) {
        this.personaggioService = personaggioService;
    }
	
	
	@GetMapping(value = {"/personaggi"})
    public ResponseEntity<List<Personaggio>> getPersonaggi(){
		return ResponseEntity.ok(personaggioService.getAll());
    }
	
	@GetMapping(value = {"/personaggi/{id}"})
    public ResponseEntity<Personaggio> getPersonaggio(@PathVariable Integer id){
		return ResponseEntity.ok(personaggioService.getById(id));
    }
	
	@PostMapping(value = {"/personaggi/{id}"})
    public ResponseEntity<String> setPersonaggio(@RequestBody Personaggio p, @PathVariable Integer id){
		personaggioService.save(p);
		
		return ResponseEntity.ok("Modifica salvata");
    }
	
	
	
}
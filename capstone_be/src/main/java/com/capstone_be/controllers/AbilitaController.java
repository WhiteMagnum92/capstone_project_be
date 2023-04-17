package com.capstone_be.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.capstone_be.entities.Abilita;
import com.capstone_be.services.AbilitaService;

@RestController
@RequestMapping("/api")
public class AbilitaController {
	
	@Autowired
	AbilitaService abilitaService;
	// prendo tutte le abilita
	@GetMapping(value = { "/abilita" })
	public ResponseEntity<List<Abilita>> getAbilita() {
		return ResponseEntity.ok(abilitaService.getAll());
	}
}

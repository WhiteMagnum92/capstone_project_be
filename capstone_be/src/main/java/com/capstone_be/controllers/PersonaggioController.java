package com.capstone_be.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.User;
import com.capstone_be.services.PersonaggioService;
import com.capstone_be.services.UserService;
import com.capstone_be.utilities.Barbaro;
import com.capstone_be.utilities.Bardo;
import com.capstone_be.utilities.Chierico;
import com.capstone_be.utilities.Classe;
import com.capstone_be.utilities.Domanda;
import com.capstone_be.utilities.Dragonide;
import com.capstone_be.utilities.Druido;
import com.capstone_be.utilities.Elfo;
import com.capstone_be.utilities.Gnomo;
import com.capstone_be.utilities.Guerriero;
import com.capstone_be.utilities.Halfling;
import com.capstone_be.utilities.Ladro;
import com.capstone_be.utilities.Mago;
import com.capstone_be.utilities.Mezzelfo;
import com.capstone_be.utilities.Mezzorco;
import com.capstone_be.utilities.Monaco;
import com.capstone_be.utilities.Nano;
import com.capstone_be.utilities.Paladino;
import com.capstone_be.utilities.Ranger;
import com.capstone_be.utilities.Razza;
import com.capstone_be.utilities.Stregone;
import com.capstone_be.utilities.Tiefling;
import com.capstone_be.utilities.Warlock;

@RestController
@RequestMapping("/api")
public class PersonaggioController {

	@Autowired
	private PersonaggioService personaggioService;
	@Autowired
	private UserService userService;

	/*
	 * public CapstoneController(PersonaggioService personaggioService) {
	 * this.personaggioService = personaggioService; }
	 */

	@GetMapping(value = { "/personaggi" })
	public ResponseEntity<List<Personaggio>> getPersonaggi() {
		return ResponseEntity.ok(personaggioService.getAll());
	}

	@GetMapping(value = { "/personaggi/{id}" })
	public ResponseEntity<Personaggio> getPersonaggio(@PathVariable Integer id) {
		return ResponseEntity.ok(personaggioService.getById(id));
	}

	// crea nuovo personaggio
	@GetMapping(value = { "/{username}/personaggi/new/{nome}" })
	public ResponseEntity<String> creaPersonaggio(@PathVariable String nome, @PathVariable String username) {
		Optional<User> user = userService.cercaTramiteUsername(username);
		Personaggio oldP = personaggioService.findByName(nome);
		if (oldP != null)
			return ResponseEntity.ok("Personaggio con stesso nome già presente");
		if (!user.isPresent())
			return ResponseEntity.ok("Utente non trovato");
		User u = user.get();
		Personaggio p = new Personaggio();
		p.setName(nome);
		p.setUser(u);
		personaggioService.save(p);
		// p=personaggioService.findByName(nome);
		// valutare se id è gia buono

		return ResponseEntity.ok(""+p.getId());
	}

	// tira fuori le domande sulla classe per il FE
	@GetMapping(value = { "/personaggi/{id}/setrazza" })
	public ResponseEntity<List<Domanda>> setRazza(@PathVariable Integer id, @RequestParam String razza) {
		Personaggio p = personaggioService.getById(id);
		p.setRazza(razza);
		Razza r = null;
		switch (razza) {
		case "Dragonide":
			r = new Dragonide();
			break;
		case "Elfo":
			r = new Elfo();
			break;
		case "Gnomo":
			r = new Gnomo();
			break;
		case "Halfling":
			r = new Halfling();
			break;
		case "Mezzelfo":
			r = new Mezzelfo();
			break;
		case "Mezzorco":
			r = new Mezzorco();
			break;
		case "Nano":
			r = new Nano();
			break;
		case "Tiefling":
			r = new Tiefling();
			break;
		case "Umano":
			r = new Mezzelfo();
			break;
		}
		r.applicaCambiamenti(p);
		personaggioService.save(p);
		List<Domanda> domande = r.modificheNecessarie();
		return ResponseEntity.ok(domande);
	}

	// set razza di un personaggio
	@PostMapping(value = { "/personaggi/{id}/setrazza" })
	public ResponseEntity<Boolean> setRisposteRazza(@RequestBody List<List<String>> risposte,
			@PathVariable Integer id) {
		Personaggio p = personaggioService.getById(id);
		String razza = p.getRazza();
		Razza r = null;
		switch (razza) {
		case "Dragonide":
			r = new Dragonide();
			break;
		case "Elfo":
			r = new Elfo();
			break;
		case "Gnomo":
			r = new Gnomo();
			break;
		case "Halfling":
			r = new Halfling();
			break;
		case "Mezzelfo":
			r = new Mezzelfo();
			break;
		case "Mezzorco":
			r = new Mezzorco();
			break;
		case "Nano":
			r = new Nano();
			break;
		case "Tiefling":
			r = new Tiefling();
			break;
		case "Umano":
			r = new Mezzelfo();
			break;
		}
		Boolean res = r.setModifiche(risposte, p);
		if (res)
			personaggioService.save(p);
		return ResponseEntity.ok(res);
	}
	
	@PostMapping(value= {"/personaggi/{id}/setcaratteristiche"})
	public ResponseEntity<String> setCarat(@RequestBody List<Integer> carat, @PathVariable Integer id ){
		Personaggio p=personaggioService.getById(id);
		if(p==null)
			return ResponseEntity.badRequest().body("Personaggio non trovato");
		if(carat==null||carat.size()!=6)
			return  ResponseEntity.badRequest().body("Caratteristiche non valide");
		p.setCaratteristiche(carat);
		personaggioService.save(p);
		return  ResponseEntity.ok("Caratteristiche salvate");
	}

	// tira fuori le domande sulla classe per il FE
	@GetMapping(value = { "/personaggi/{id}/setclasse" })
	public ResponseEntity<List<Domanda>> setClasse(@PathVariable Integer id, @RequestParam String classe) {
		Personaggio p = personaggioService.getById(id);
		p.setClasse(classe);
		Classe c = null;
		switch (classe) {
		case "Barbaro":
			c = new Barbaro();
			break;
		case "Bardo":
			c = new Bardo();
			break;
		case "Chierico":
			c = new Chierico();
			break;
		case "Druido":
			c = new Druido();
			break;
		case "Guerriero":
			c = new Guerriero();
			break;
		case "Ladro":
			c = new Ladro();
			break;
		case "Mago":
			c = new Mago();
			break;
		case "Monaco":
			c = new Monaco();
			break;
		case "Paladino":
			c = new Paladino();
			break;
		case "Ranger":
			c = new Ranger();
			break;
		case "Stregone":
			c = new Stregone();
			break;
		case "Warlock":
			c = new Warlock();
			break;
		}
		c.applicaCambiamenti(p);
		personaggioService.save(p);
		List<Domanda> domande = c.modificheNecessarie();
		return ResponseEntity.ok(domande);
	}

	// set classe di un personaggio
	@PostMapping(value = { "/personaggi/{id}/setclasse" })
	public ResponseEntity<Boolean> setRisposteClasse(@RequestBody List<List<String>> risposte,
			@PathVariable Integer id) {
		Personaggio p = personaggioService.getById(id);
		String classe = p.getClasse();
		Classe c = null;
		switch (classe) {
		case "Barbaro":
			c = new Barbaro();
			break;
		case "Bardo":
			c = new Bardo();
			break;
		case "Chierico":
			c = new Chierico();
			break;
		case "Druido":
			c = new Druido();
			break;
		case "Guerriero":
			c = new Guerriero();
			break;
		case "Ladro":
			c = new Ladro();
			break;
		case "Mago":
			c = new Mago();
			break;
		case "Monaco":
			c = new Monaco();
			break;
		case "Paladino":
			c = new Paladino();
			break;
		case "Ranger":
			c = new Ranger();
			break;
		case "Stregone":
			c = new Stregone();
			break;
		case "Warlock":
			c = new Warlock();
			break;
		}
		Boolean res = c.setModifiche(risposte, p);
		if (res)
			personaggioService.save(p);
		return ResponseEntity.ok(res);
	}

	// delete un personaggio tramite id utente e nome personaggio
	@DeleteMapping("/{userId}/delete/personaggi/{nomePersonaggio}")
	@PreAuthorize("hasRole('ADMIN')or hasRole('USER')")
	public ResponseEntity<?> deletePersonaggio(@PathVariable("userId") Long userId,
			@PathVariable("nomePersonaggio") String nomePersonaggio) {
		personaggioService.deletePersonaggio(nomePersonaggio, userId);
		return ResponseEntity.ok().build();
	}

}

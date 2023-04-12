package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

@Component
public class Mezzelfo implements Razza {
	
	@Autowired
	PrivilegioService serv;

	@Override
	public void applicaCambiamenti(Personaggio p) {
		// settaggio degli aumenti di caratteristica
		List<Integer> caratteristiche = p.getCaratteristiche();
		int car = caratteristiche.get(5);
		car = car + 2;
		caratteristiche.set(5, car);
		p.setCaratteristiche(caratteristiche);
		// settaggio della taglia
		p.setTaglia("media");
		// settaggio altezza media
		p.setAltezza(165);
		// settaggio velocita
		p.setVelocita(9.0);
		// settaggio dei privilegi
		Privilegio priv = serv.findByName("Scurovisione");
		Privilegio priv1 = serv.findByName("Versatilità nelle abilità");
		Privilegio priv2 = serv.findByName("Retaggio fatato");
		List<Privilegio> oldPriv = p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		p.setPrivilegi(oldPriv);
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.ELFICO);
		linguaggi.add(Linguaggio.CUSTOM);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.ELFICO) && lista.size() == 3
				&& !lista.contains(Linguaggio.CUSTOM)) {
			List<Linguaggio> list = p.getLinguaggi();
			list.addAll(lista);
			p.setLinguaggi(list);
			return true;
		} else
			return false;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		List<Domanda> result = new ArrayList<Domanda>();
		Domanda d = new Domanda();
		d.descrizioni = new ArrayList<String>();
		d.numeroRisposte = 2;
		d.domanda = "Scegliere due caratteristiche che aumenteranno di 1";
		d.possibiliRisposte = new ArrayList<String>();
		d.possibiliRisposte.add("Forza");
		d.possibiliRisposte.add("Destrezza");
		d.possibiliRisposte.add("Costituzione");
		d.possibiliRisposte.add("Intelligenza");
		d.possibiliRisposte.add("Saggezza");
		result.add(d);
		Domanda d1 = new Domanda();
		AbilitaService serv = new AbilitaService();
		List<Abilita> abilities = serv.getAll();
		d1.numeroRisposte = 2;
		d1.domanda = "Scegliere due abilità in cui si avrà competenza";
		d1.possibiliRisposte = new ArrayList<String>();
		d1.descrizioni = new ArrayList<String>();
		abilities.stream().forEach(a -> {
			d1.possibiliRisposte.add(a.getName());
			d1.descrizioni.add(a.getDescrizione());
		});
		result.add(d1);
		return result;
	}

	@Override
	public Boolean setModifiche(List<List<String>> risposte, Personaggio p) {
		if (risposte == null || risposte.size() != 2)
			return false;
		List<String> risp1 = risposte.get(0);
		List<String> possibiliRisposte = new ArrayList<String>();
		possibiliRisposte.add("Forza");
		possibiliRisposte.add("Destrezza");
		possibiliRisposte.add("Costituzione");
		possibiliRisposte.add("Intelligenza");
		possibiliRisposte.add("Saggezza");
		if (risp1 == null || risp1.size() != 2 || risp1.stream().anyMatch(r -> !possibiliRisposte.contains(r))) {
			return false;
		}
		List<String> risp2 = risposte.get(1);
		AbilitaService serv = new AbilitaService();
		List<String> possibiliRisposte2 = serv.getAll().stream().map(a -> a.getName()).toList();
		if (risp2 == null || risp2.size() != 2 || risp2.stream().anyMatch(r -> !possibiliRisposte2.contains(r))) {
			return false;
		}

		List<Integer> caratt = p.getCaratteristiche();
		risp1.stream().forEach(r -> {
			switch (r) {
			case "Forza":
				caratt.set(0, caratt.get(0) + 1);
				break;
			case "Destrezza":
				caratt.set(1, caratt.get(1) + 1);
				break;
			case "Costituzione":
				caratt.set(2, caratt.get(2) + 1);
				break;
			case "Intelligenza":
				caratt.set(3, caratt.get(3) + 1);
				break;
			case "Saggezza":
				caratt.set(4, caratt.get(4) + 1);
				break;
			}
		});
		p.setCaratteristiche(caratt);
		List<Abilita> abilities = p.getAbilita();
		risp2.stream().forEach(r -> {
			abilities.add(serv.findByName(r));
		});
		p.setAbilita(abilities);
		return true;
	}

}

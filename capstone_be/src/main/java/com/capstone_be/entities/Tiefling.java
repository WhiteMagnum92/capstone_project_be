package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Tiefling implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		List<Integer> caratteristiche = p.getCaratteristiche();
		int inte = caratteristiche.get(3);
		inte = inte + 1;
		caratteristiche.set(3, inte); 
		int car = caratteristiche.get(5);
		car = car + 2;
		caratteristiche.set(5, car); 
		p.setCaratteristiche(caratteristiche);
		//settaggio della taglia
		p.setTaglia("media");
		//settaggio altezza media
		p.setAltezza(165);
		//settaggio velocita
		p.setVelocita(9.0);
		// settaggio dei privilegi
		Privilegio p1 = new Privilegio("Scurovisione", "Possibilita di vedere fino a 18m al buio");
		Privilegio p2 = new Privilegio("Resistenza Infernale", "Resistenza ai danni da fuoco");
		Privilegio p3 = new Privilegio("Eredita Infernale", "Conoscete il trucchetto taumaturgia. Una volta raggiunto il 3° livello, potete lanciare l'incantesimo rimprovero diabolico una volta al giorno come incantesimo di 2° livello. Una volta raggiunto il 5° livello, potete anche lanciare l'incantesimo oscurità una volta al giorno. Il Carisma è la caratteristica chiave per questi incantesimi. ");
		List<Privilegio> privilegi = p.getPrivilegi();
		privilegi.add(p1);
		privilegi.add(p2);
		privilegi.add(p3);
		p.setPrivilegi(privilegi);
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.INFERNALE);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.INFERNALE) && lista.size()==2) {
			p.linguaggi.addAll(lista);
			return true;
			}else 
			return false;
	}

	@Override
	public Boolean setModificheCaratteristiche(List<Integer> cararatt, Personaggio p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> modificheCaratteristichePossibili() {
		// TODO Auto-generated method stub
		return null;
	}

}

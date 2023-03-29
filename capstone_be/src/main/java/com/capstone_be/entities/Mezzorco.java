package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Mezzorco implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		List<Integer> caratteristiche = p.getCaratteristiche();
		int forz = caratteristiche.get(0);
		forz = forz + 2;
		caratteristiche.set(0, forz);
		int cos = caratteristiche.get(2);
		cos = cos + 1;
		caratteristiche.set(2, cos);
		p.setCaratteristiche(caratteristiche);
		//settaggio della taglia
		p.setTaglia("media");
		//settaggio altezza media
		p.setAltezza(180);
		//settaggio velocita
		p.setVelocita(9.0);
		
		Privilegio p1 = new Privilegio("Scurovisione", "Possibilita di vedere fino a 18m al buio");
		Privilegio p2 = new Privilegio("Minaccioso", "competenza nell'abilita intimidire");
		Privilegio p3 = new Privilegio("Tenacia Implacabile", "Quando un mezzorco scende a 0 PF ma non viene ucciso sul colpo, puo decidere di rimanere a 1 PF. Non puo utlizzare questa capacita finche non completa un riposto lungo");
		Privilegio p4 = new Privilegio("Attacchi Selvaggi", "Quando mette a segno un colpo critico con un'arma da mischia. puo tirare un dado dell'arma aggiuntivo quando determina i danni extra del colpo critico");
		List<Privilegio> privilegi = p.getPrivilegi();
		privilegi.add(p1);
		privilegi.add(p2);
		privilegi.add(p3);
		privilegi.add(p4);
		p.setPrivilegi(privilegi);
		
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.ORCHESCO);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.ORCHESCO) && lista.size()==2) {
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
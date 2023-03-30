package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Nano implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		// settaggio degli aumenti di caratteristica
					List<Integer> caratteristiche = p.getCaratteristiche();
					int cos = caratteristiche.get(2);
					cos = cos + 2;
					caratteristiche.set(2, cos); 
					p.setCaratteristiche(caratteristiche);
					//settaggio della taglia
					p.setTaglia("media");
					//settaggio altezza media
					p.setAltezza(135);
					//settaggio velocita
					p.setVelocita(7.5);
					// settaggio dei privilegi
					/*
					 * Privilegio p1 = new Privilegio("Scurovisione",
					 * "Possibilita di vedere fino a 18m al buio"); Privilegio p2 = new
					 * Privilegio("Resilienza Nanica",
					 * "Vantaggio ai TS veleno e di resistenza ai danni da veleno"); Privilegio p3 =
					 * new Privilegio("Addestramento da Combattimento Nanico",
					 * "Compentenza in asce, asce da battaglia, martelli da guerra e martelli leggeri"
					 * ); Privilegio p4 = new Privilegio("Competenza negli strumenti",
					 * "Compentenza in un gruppo di strumenti da artigiano a sua scelta");
					 * Privilegio p5 = new Privilegio("Esperto Minatore",
					 * "Ognivolta che un nano effetua una prova di intelligenza (Storia) relativa all'origine di una struttura in pietra, aggiunge il doppio del suo bonus di competenza"
					 * ); List<Privilegio> privilegi = p.getPrivilegi(); privilegi.add(p1);
					 * privilegi.add(p2); privilegi.add(p3); privilegi.add(p4); privilegi.add(p5);
					 * p.setPrivilegi(privilegi);
					 */
		
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.NANICO);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.NANICO) && lista.size()==2) {
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

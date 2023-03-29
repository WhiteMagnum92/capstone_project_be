package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Halfling implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		// settaggio degli aumenti di caratteristica
					List<Integer> caratteristiche = p.getCaratteristiche();
					int dex = caratteristiche.get(1);
					dex = dex + 2;
					caratteristiche.set(1, dex); 
					p.setCaratteristiche(caratteristiche);
					//settaggio della taglia
					p.setTaglia("piccola");
					//settaggio altezza media
					p.setAltezza(90);
					//settaggio velocita
					p.setVelocita(7.5);
					// settaggio dei privilegi
					Privilegio p1 = new Privilegio("Fortunato", "Quando ottiene 1 a un tiro per colpire, a una prova di caratteristica o a un tiro salvezza, puo ripetere il tiro del dado e deve usare il nuovo risultato");
					Privilegio p2 = new Privilegio("Coraggioso", "Vantaggio ai TS per non essere spaventato");
					Privilegio p3 = new Privilegio("Agilita Halfling", "Puo muoversi attraverso gli spazi di qualsiasi creatura piu grande");
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
		linguaggi.add(Linguaggio.HALFLING);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.HALFLING) && lista.size()==2) {
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

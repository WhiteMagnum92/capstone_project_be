package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import com.capstone_be.entities.Personaggio;

public class Gnomo implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		List<Integer> caratteristiche = p.getCaratteristiche();
		int inte = caratteristiche.get(3);
		inte = inte + 2;
		caratteristiche.set(3, inte); 
		p.setCaratteristiche(caratteristiche);
		//settaggio della taglia
		p.setTaglia("piccola");
		//settaggio altezza media
		p.setAltezza(100);
		//settaggio velocita
		p.setVelocita(7.5);
		// settaggio dei privilegi
		/*
		 * Privilegio p1 = new Privilegio("Scurovisione",
		 * "Possibilita di vedere fino a 18m al buio"); Privilegio p2 = new
		 * Privilegio("Astuzia Gnomesca",
		 * "Vantaggio ai TS su intelligenza, saggezza, carisma contro la magia");
		 * List<Privilegio> privilegi = p.getPrivilegi(); privilegi.add(p1);
		 * privilegi.add(p2); p.setPrivilegi(privilegi);
		 */
		
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.GNOMESCO);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.GNOMESCO) && lista.size()==2) {
			List<Linguaggio> list=p.getLinguaggi();
			list.addAll(lista);
			p.setLinguaggi(list);
			return true;
		}
		else 
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

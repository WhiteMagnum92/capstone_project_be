package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Umano implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		List<Integer> caratteristiche = p.getCaratteristiche();
		for(int i = 0; i < caratteristiche.size(); i++) {
		    caratteristiche.set(i, caratteristiche.get(i) + 1);
		} 
		p.setCaratteristiche(caratteristiche);
		//settaggio della taglia
		p.setTaglia("media");
		//settaggio altezza media
		p.setAltezza(165);
		//settaggio velocita
		p.setVelocita(9.0);
		
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.CUSTOM);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.size()==2 && !lista.contains(Linguaggio.CUSTOM)) {
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

package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

public class Dragonide implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		List<Integer> caratteristiche = p.getCaratteristiche();
		int forz = caratteristiche.get(0);
		forz = forz + 2;
		caratteristiche.set(0, forz);
		int car = caratteristiche.get(5);
		car = car + 1;
		caratteristiche.set(5, car);
		p.setCaratteristiche(caratteristiche);
		//settaggio della taglia
		p.setTaglia("media");
		//settaggio altezza media
		p.setAltezza(180);
		//settaggio velocita
		p.setVelocita(9.0);
		// settaggio dei privilegi
		
	}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.DRACONICO);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.DRACONICO) && lista.size()==2) {
			p.linguaggi.addAll(lista);
			return true;
			}else 
			return false;
	}

	
	public Boolean setModifiche(List<Integer> cararatt, Personaggio p) {
		// TODO Auto-generated method stub
		return null;
	}

	
	public List<String> modifichePossibili() {
		// TODO Auto-generated method stub
		return null;
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
package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.PrivilegioService;

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
					PrivilegioService serv= new PrivilegioService();
					Privilegio priv=serv.findByName("Scurovisione");
					Privilegio priv1=serv.findByName("Resilienza nanica");
					Privilegio priv2=serv.findByName("Esperto minatore");
					List<Privilegio> oldPriv=p.getPrivilegi();
					oldPriv.add(priv);
					oldPriv.add(priv1);
					oldPriv.add(priv2);
					p.setPrivilegi(oldPriv);
		
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

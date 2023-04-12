package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.PrivilegioService;

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
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Scurovisione");
		Privilegio priv1=serv.findByName("Astuzia gnomesca");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		p.setPrivilegi(oldPriv);
		
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
	public Boolean setModifiche(List<List<String>> risposte, Personaggio p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		// TODO Auto-generated method stub
		return null;
	}


}

package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.PrivilegioService;

@Component
public class Halfling implements Razza {

	@Autowired
	PrivilegioService serv;

	@Override
	public void applicaCambiamenti(Personaggio p) {
		// settaggio degli aumenti di caratteristica
		List<Integer> caratteristiche = p.getCaratteristiche();
		int dex = caratteristiche.get(1);
		dex = dex + 2;
		caratteristiche.set(1, dex);
		p.setCaratteristiche(caratteristiche);
		// settaggio della taglia
		p.setTaglia("piccola");
		// settaggio altezza media
		p.setAltezza(90);
		// settaggio velocita
		p.setVelocita(7.5);
		// settaggio dei privilegi
		Privilegio priv = serv.findByName("Frotunato");
		Privilegio priv1 = serv.findByName("Coraggioso");
		Privilegio priv2 = serv.findByName("Agilità halfling");
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
		linguaggi.add(Linguaggio.HALFLING);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.HALFLING) && lista.size() == 2) {
			List<Linguaggio> list = p.getLinguaggi();
			list.addAll(lista);
			p.setLinguaggi(list);
			return true;
		} else
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

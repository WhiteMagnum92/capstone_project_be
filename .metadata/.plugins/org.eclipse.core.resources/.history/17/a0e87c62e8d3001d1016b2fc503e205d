package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.PrivilegioService;

public class Elfo implements Razza {

	@Override
	public void applicaCambiamenti(Personaggio p) {
			
			// settaggio degli aumenti di caratteristica
			List<Integer> caratteristiche = p.getCaratteristiche();
			int dex = caratteristiche.get(1);
			dex = dex + 2;
			caratteristiche.set(1, dex); 
			p.setCaratteristiche(caratteristiche);
			//settaggio della taglia
			p.setTaglia("media");
			//settaggio altezza media
			p.setAltezza(165);
			//settaggio velocita
			p.setVelocita(9.0);
			// settaggio dei privilegi
			PrivilegioService serv= new PrivilegioService();
			Privilegio priv=serv.findByName("Scurovisione");
			Privilegio priv1=serv.findByName("Sensi Acuti");
			Privilegio priv2=serv.findByName("Retaggio fatato");
			Privilegio priv3=serv.findByName("Trance");
			List<Privilegio> oldPriv=p.getPrivilegi();
			oldPriv.add(priv);
			oldPriv.add(priv1);
			oldPriv.add(priv2);
			oldPriv.add(priv3);
			p.setPrivilegi(oldPriv);
			 
		}

	@Override
	public List<Linguaggio> linguaggiPossibili() {
		List<Linguaggio> linguaggi = new ArrayList<Linguaggio>();
		linguaggi.add(Linguaggio.COMUNE);
		linguaggi.add(Linguaggio.ELFICO);
		linguaggi.add(Linguaggio.CUSTOM);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.ELFICO) && lista.size()==3 && !lista.contains(Linguaggio.CUSTOM)) {
			List<Linguaggio> list=p.getLinguaggi();
			list.addAll(lista);
			p.setLinguaggi(list);
			return true;
		}
		else 
			return false;
	}

	@Override
	public Boolean setModificheCaratteristiche(List<Integer> cara, Personaggio p) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> modificheCaratteristichePossibili() {
		// TODO Auto-generated method stub
		return null;
	}
		
	}
	



package com.capstone_be.entities;

import java.util.ArrayList;
import java.util.List;

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
			Privilegio p1 = new Privilegio("Scurovisione", "Possibilita di vedere fino a 18m al buio");
			Privilegio p2 = new Privilegio("Trance", "Anziche dormire 8 ore, trance per 4");
			Privilegio p3 = new Privilegio("Retaggio Fatato", "Vantaggio TS contro affascinamento e non puo essere addormentato magicamente");
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
		linguaggi.add(Linguaggio.ELFICO);
		linguaggi.add(Linguaggio.CUSTOM);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.ELFICO) && lista.size()==3 && !lista.contains(Linguaggio.CUSTOM)) {
		p.linguaggi.addAll(lista);
		return true;
		}else 
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
	



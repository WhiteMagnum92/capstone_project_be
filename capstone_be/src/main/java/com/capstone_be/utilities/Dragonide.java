package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

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
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Discendenza draconica");
		Privilegio priv1=serv.findByName("Arma a soffio");
		Privilegio priv2=serv.findByName("Resistenza ai danni");
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
		linguaggi.add(Linguaggio.DRACONICO);
		return linguaggi;
	}

	@Override
	public Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p) {
		if (lista.contains(Linguaggio.COMUNE) && lista.contains(Linguaggio.DRACONICO) && lista.size()==2) {
			List<Linguaggio> list=p.getLinguaggi();
			list.addAll(lista);
			p.setLinguaggi(list);
			return true;
		}
		else 
			return false;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		List<Domanda> result = new ArrayList<Domanda>();
		Domanda d = new Domanda();
		d.descrizioni = new ArrayList<String>();
		d.numeroRisposte = 1;
		d.domanda = "Scegliere la discendenza draconica";
		d.possibiliRisposte = new ArrayList<String>();
		d.possibiliRisposte.add("Argento");
		d.possibiliRisposte.add("Bianco");
		d.possibiliRisposte.add("Blu");
		d.possibiliRisposte.add("Bronzo");
		d.possibiliRisposte.add("Nero");
		d.possibiliRisposte.add("Oro");
		d.possibiliRisposte.add("Ottone");
		d.possibiliRisposte.add("Rame");
		d.possibiliRisposte.add("Rosso");
		d.possibiliRisposte.add("Verde");
		d.descrizioni.add("Danno: freddo  Arma a soffio: cono  TS: costituzione");
		d.descrizioni.add("Danno: freddo  Arma a soffio: cono  TS: costituzione");
		d.descrizioni.add("Danno: fulmine  Arma a soffio: linea  TS: destrezza");
		d.descrizioni.add("Danno: fulmine  Arma a soffio: linea  TS: destrezza");
		d.descrizioni.add("Danno: acido  Arma a soffio: linea  TS: destrezza");
		d.descrizioni.add("Danno: fuoco  Arma a soffio: cono  TS: destrezza");
		d.descrizioni.add("Danno: fuoco  Arma a soffio: linea  TS: destrezza");
		d.descrizioni.add("Danno: acido  Arma a soffio: linea  TS: destrezza");
		d.descrizioni.add("Danno: fuoco  Arma a soffio: cono  TS: destrezza");
		d.descrizioni.add("Danno: veleno  Arma a soffio: cono  TS: costituzione");
		result.add(d);
		return result;
	}

	@Override
	public Boolean setModifiche(List<List<String>> risposte, Personaggio p) {
		if(risposte==null||risposte.size()!=1)
			return false;
		List<String> risposta = risposte.get(0);
		List<String> possibiliRisposte = new ArrayList<String>();
		possibiliRisposte.add("Argento");
		possibiliRisposte.add("Bianco");
		possibiliRisposte.add("Blu");
		possibiliRisposte.add("Bronzo");
		possibiliRisposte.add("Nero");
		possibiliRisposte.add("Oro");
		possibiliRisposte.add("Ottone");
		possibiliRisposte.add("Rame");
		possibiliRisposte.add("Rosso");
		possibiliRisposte.add("Verde");
		if(risposta == null || risposta.size()!=1 || !possibiliRisposte.contains(risposta.get(0)))
			return false;
		Map<String,String> genVal=p.getGenericValue();
		switch (risposta.get(0)) {
			case "Argento":
				genVal.put("Tipo danno","Freddo");
				genVal.put("Arma soffio","Cono");
				genVal.put("Tiro Salvezza","Costituzione");
				p.setGenericValue(genVal);
				break;
			case "Bianco":
				genVal.put("Tipo danno","Freddo");
				genVal.put("Arma soffio","Cono");
				genVal.put("Tiro Salvezza","Costituzione");
				p.setGenericValue(genVal);
				break;
			case "Blu":
				genVal.put("Tipo danno","Fulmine");
				genVal.put("Arma soffio","Linea");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Bronzo":
				genVal.put("Tipo danno","Fulmine");
				genVal.put("Arma soffio","Linea");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Nero":
				genVal.put("Tipo danno","Acido");
				genVal.put("Arma soffio","Linea");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Oro":
				genVal.put("Tipo danno","Fuoco");
				genVal.put("Arma soffio","Cono");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Ottone":
				genVal.put("Tipo danno","Fuoco");
				genVal.put("Arma soffio","Linea");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Rame":
				genVal.put("Tipo danno","Acido");
				genVal.put("Arma soffio","Linea");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Rosso":
				genVal.put("Tipo danno","Fuoco");
				genVal.put("Arma soffio","Cono");
				genVal.put("Tiro Salvezza","Destrezza");
				p.setGenericValue(genVal);
				break;
			case "Verde":
				genVal.put("Tipo danno","Veleno");
				genVal.put("Arma soffio","Cono");
				genVal.put("Tiro Salvezza","Costituzione");
				p.setGenericValue(genVal);
				break;
		}
		
		return true;
	}

	

}

package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

public class Ranger implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		p.setDv("1d10");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(10+modCos);
		p.setCompetenza(2);
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Scudi");
		Privilegio priv1=serv.findByName("Armature leggere");
		Privilegio priv2=serv.findByName("Armature medie");
		Privilegio priv3=serv.findByName("Esploratore nato");
		Privilegio priv4=serv.findByName("Armi semplici");
		Privilegio priv5=serv.findByName("Armi da guerra");
		Privilegio priv6=serv.findByName("Nemico prescelto");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		oldPriv.add(priv3);
		oldPriv.add(priv4);
		oldPriv.add(priv5);
		oldPriv.add(priv6);
		p.setPrivilegi(oldPriv);
	}

	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		AbilitaService serv= new AbilitaService();
		Integer num=3;
		List<Abilita> lista=serv.getAll();
		Pair<Integer,List<Abilita>> result =Pair.of(num, lista);
		return result;
	}

	@Override
	public Boolean setAbilita(Personaggio p, List<Abilita> lista) {
		if(lista.size()!=3)
			return false;
		List<Abilita> oldList= p.getAbilita();
		oldList.addAll(lista);
		p.setAbilita(oldList);
		return true;
	}

	@Override
	public Pair<Integer, List<Incantesimo>> incantesimiPossibili(Integer liv) {
		return null;
	}

	@Override
	public Boolean setIncantesimi(Personaggio p, List<Incantesimo> lista) {
		return null;
	}

	@Override
	public Boolean setModifiche(List<List<String>> risposte, Personaggio p) {
		if (risposte == null || risposte.size()!=2) 
			return false;
		List<String> possibiliRisposte = new ArrayList<String>();
		possibiliRisposte.add("Aberrazioni");
		possibiliRisposte.add("Bestie");
		possibiliRisposte.add("Celestiali");
		possibiliRisposte.add("Costrutti");
		possibiliRisposte.add("Draghi");
		possibiliRisposte.add("Elementali");
		possibiliRisposte.add("Folletti");
		possibiliRisposte.add("Giganti");
		possibiliRisposte.add("Immondi");
		possibiliRisposte.add("Melme");
		possibiliRisposte.add("Mostruosità");
		possibiliRisposte.add("Non morti");
		possibiliRisposte.add("Vegetali");
		if (risposte.get(0).size()!=1 || !possibiliRisposte.contains(risposte.get(0).get(0)))
			return false;
		List<String> possibiliRisposte1 = new ArrayList<String>();
		possibiliRisposte1.add("Artico");
		possibiliRisposte1.add("Costa");
		possibiliRisposte1.add("Deserto");
		possibiliRisposte1.add("Foresta");
		possibiliRisposte1.add("Montagna");
		possibiliRisposte1.add("Palude");
		possibiliRisposte1.add("Prateria");
		possibiliRisposte1.add("Underdark");
		if (risposte.get(1).size()!=1 || !possibiliRisposte1.contains(risposte.get(1).get(0)))
			return false;
		String ris = risposte.get(0).get(0);
		String ris1 = risposte.get(1).get(0);
		
		Map<String, String> mappa = p.getGenericValue();
		mappa.put("Nemico prescelto", ris);
		mappa.put("Terreno prescelto", ris1);
		p.setGenericValue(mappa);
		return true;		
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		List<Domanda> res = new ArrayList<Domanda>();
		Domanda d = new Domanda();
		d.domanda = "Scegliere un nemico prescelto";
		d.numeroRisposte = 1;
		d.possibiliRisposte = new ArrayList<String>();
		d.possibiliRisposte.add("Aberrazioni");
		d.possibiliRisposte.add("Bestie");
		d.possibiliRisposte.add("Celestiali");
		d.possibiliRisposte.add("Costrutti");
		d.possibiliRisposte.add("Draghi");
		d.possibiliRisposte.add("Elementali");
		d.possibiliRisposte.add("Folletti");
		d.possibiliRisposte.add("Giganti");
		d.possibiliRisposte.add("Immondi");
		d.possibiliRisposte.add("Melme");
		d.possibiliRisposte.add("Mostruosità");
		d.possibiliRisposte.add("Non morti");
		d.possibiliRisposte.add("Vegetali");
		res.add(d);
		Domanda d1 = new Domanda();
		d1.domanda = "Scegliere un tipo di terreno prescelto";
		d1.numeroRisposte = 1;
		d1.possibiliRisposte = new ArrayList<String>();
		d1.possibiliRisposte.add("Artico");
		d1.possibiliRisposte.add("Costa");
		d1.possibiliRisposte.add("Deserto");
		d1.possibiliRisposte.add("Foresta");
		d1.possibiliRisposte.add("Montagna");
		d1.possibiliRisposte.add("Palude");
		d1.possibiliRisposte.add("Prateria");
		d1.possibiliRisposte.add("Underdark");
		res.add(d1);
		return res;
	}

	

}

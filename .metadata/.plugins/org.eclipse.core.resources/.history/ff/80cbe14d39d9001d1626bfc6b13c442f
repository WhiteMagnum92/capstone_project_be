package com.capstone_be.utilities;

import java.util.List;

import org.springframework.data.util.Pair;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

public class Paladino implements Classe {

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
		Privilegio priv3=serv.findByName("Armature pesanti");
		Privilegio priv4=serv.findByName("Armi semplici");
		Privilegio priv5=serv.findByName("Armi da guerra");
		Privilegio priv6=serv.findByName("Percezione del divino");
		Privilegio priv7=serv.findByName("Imposizione delle mani");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		oldPriv.add(priv3);
		oldPriv.add(priv4);
		oldPriv.add(priv5);
		oldPriv.add(priv6);
		oldPriv.add(priv7);
		p.setPrivilegi(oldPriv);
	}

	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		// TODO Auto-generated method stub
		AbilitaService serv= new AbilitaService();
		Integer num=2;
		List<Abilita> lista=serv.getAll();
		Pair<Integer,List<Abilita>> result =Pair.of(num, lista);
		return result;
	}

	@Override
	public Boolean setAbilita(Personaggio p, List<Abilita> lista) {
		if(lista.size()!=2)
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
		return null;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		return null;
	}

	
}

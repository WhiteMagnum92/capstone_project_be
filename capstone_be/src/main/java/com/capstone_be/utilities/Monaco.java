package com.capstone_be.utilities;

import java.util.List;

import org.springframework.data.util.Pair;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

public class Monaco implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		p.setDv("1d8");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(8+modCos);
		p.setCompetenza(2);
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Difesa senza armatura");
		Privilegio priv1=serv.findByName("Arti marziali");
		Privilegio priv2=serv.findByName("Armi semplici");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
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
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setIncantesimi(Personaggio p, List<Incantesimo> lista) {
		// TODO Auto-generated method stub
		return null;
	}

	

}

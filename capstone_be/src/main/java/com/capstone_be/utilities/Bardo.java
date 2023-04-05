package com.capstone_be.utilities;

import java.util.List;
import java.util.Map;

import org.springframework.data.util.Pair;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.IncantesimiService;
import com.capstone_be.services.PrivilegioService;

public class Bardo implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		p.setDv("1d8");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(8+modCos);
		p.setCompetenza(2);
		Map<String, Integer> genval= p.getGenericValue();
		genval.put("Trucchetti", 2);
		genval.put("Incantesimi", 4);
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Ispirazione bardica");
		Privilegio priv1=serv.findByName("Armature leggere");
		Privilegio priv2=serv.findByName("Armi semplici");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		p.setPrivilegi(oldPriv);
		p.setGenericValue(genval);
		
	}

	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		// TODO Auto-generated method stub
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
		
		if(liv==1||liv==0) {
			Integer num=2;
			 IncantesimiService serv= new IncantesimiService();
			 List <Incantesimo> lista = serv.getByLvl(liv).stream().filter(inc->inc.getClasse().contains("Bardo")).toList();
			
			Pair<Integer,List<Incantesimo>> result =Pair.of(num, lista);
			return result;
		}
		else{
			Pair<Integer,List<Incantesimo>> result =Pair.of(0, null);
			return result;
		}
	}

	@Override
	public Boolean setIncantesimi(Personaggio p, List<Incantesimo> lista) {
		
		Integer lvl= lista.get(0).getLvl();
		if(lista.stream().anyMatch(inc->inc.getLvl()!=lvl))
			return false;
		IncantesimiService serv= new IncantesimiService();
		List <Incantesimo> listaBardo = serv.getByLvl(lvl).stream().filter(inc->inc.getClasse().contains("Bardo")).toList();
		for( Incantesimo inc : lista) 
		{
			if(!listaBardo.contains(inc))
				return false;
		} 
		List<Incantesimo> oldList= p.getIncantesimi();
		oldList.addAll(lista);
		p.setIncantesimi(oldList);
		return true;
	}

}
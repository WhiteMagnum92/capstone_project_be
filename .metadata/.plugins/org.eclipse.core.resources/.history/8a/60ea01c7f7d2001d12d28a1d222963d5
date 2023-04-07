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
import com.capstone_be.services.IncantesimiService;
import com.capstone_be.services.PrivilegioService;

public class Druido implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		p.setDv("1d8");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(8+modCos);
		p.setCompetenza(2);
		Map<String, Integer> genval= p.getGenericValue();
		genval.put("Trucchetti", 2);
		genval.put("Incantesimi", 2);
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Scudi");
		Privilegio priv1=serv.findByName("Armature leggere");
		Privilegio priv2=serv.findByName("Armature medie");
		Privilegio priv3=serv.findByName("Armi semplici");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		oldPriv.add(priv3);
		p.setPrivilegi(oldPriv);
		p.setGenericValue(genval);
		List<Linguaggio> list=p.getLinguaggi();
		list.add(Linguaggio.DRUIDICO);
		p.setLinguaggi(list);
		
		
	}
	
	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		AbilitaService serv= new AbilitaService();
		Integer num=2;
		List<Abilita> lista= new ArrayList<Abilita>();
		lista.add(serv.findByName("Intuizione"));
		lista.add(serv.findByName("Medicina"));
		lista.add(serv.findByName("Addestrare animali"));
		lista.add(serv.findByName("Religione"));
		lista.add(serv.findByName("Natura"));
		lista.add(serv.findByName("Sopravvivenza"));
		lista.add(serv.findByName("Arcano"));
		lista.add(serv.findByName("Percezione"));
		
		Pair<Integer,List<Abilita>> result =Pair.of(num, lista);
		return result;
	}

	@Override
	public Boolean setAbilita(Personaggio p, List<Abilita> lista) {
		AbilitaService serv= new AbilitaService();
		
		List<Abilita> listaDefault= new ArrayList<Abilita>();
		listaDefault.add(serv.findByName("Intuizione"));
		listaDefault.add(serv.findByName("Medicina"));
		listaDefault.add(serv.findByName("Addestrare animali"));
		listaDefault.add(serv.findByName("Religione"));
		listaDefault.add(serv.findByName("Natura"));
		listaDefault.add(serv.findByName("Sopravvivenza"));
		listaDefault.add(serv.findByName("Arcano"));
		listaDefault.add(serv.findByName("Percezione"));
		if(lista.size()!=2||(lista.stream().anyMatch(ab->!listaDefault.contains(ab))))
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
			 List <Incantesimo> lista = serv.getByLvl(liv).stream().filter(inc->inc.getClasse().contains("Druido")).toList();
			
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
		List <Incantesimo> listaDruido = serv.getByLvl(lvl).stream().filter(inc->inc.getClasse().contains("Druido")).toList();
		for( Incantesimo inc : lista) 
		{
			if(!listaDruido.contains(inc))
				return false;
		} 
		List<Incantesimo> oldList= p.getIncantesimi();
		oldList.addAll(lista);
		p.setIncantesimi(oldList);
		return true;
	}

}

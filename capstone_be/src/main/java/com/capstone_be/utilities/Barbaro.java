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

public class Barbaro implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		/*
		 * Privilegio p1 = new Privilegio("Ira",
		 * "Se non indossa un'armatura pesante: Vantaggio a prove di forza e TS basati su forza, "
		 * + "Bonus ai danni quando utilizza un'arma da mischia, " +
		 * "resistenza ai danni contundenti, perforanti e taglienti. " +
		 * "Non puo lanciare incantesimi o concentrarsi durante l'ira. l'ira dura 1 minuto. "
		 * +
		 * "Finisce prima se diventa incosciente o se finisce il turno senza aver attaccato una creatura ostile o se non ha subito danno dal suo ultimo turno. "
		 * + "Puo terminare l'ira con un'azione bonus. "); Privilegio p2 = new
		 * Privilegio("Difesa senza armatura", "Finche non indossa armatura, " +
		 * "la CA diventa 10 + modificatore di destrezza + modificatore di costituzione. Puo utilizzare scudi."
		 * ); List<Privilegio> privilegi = p.getPrivilegi(); privilegi.add(p1);
		 * privilegi.add(p2); p.setPrivilegi(privilegi);
		 */
		p.setDv("1d12");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(12+modCos);
		p.setCompetenza(2);
		Map<String, Integer> genval= p.getGenericValue();
		genval.put("Ira", 2);
		genval.put("Danni Ira", 2);
		p.setGenericValue(genval);
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Scudi");
		Privilegio priv1=serv.findByName("Armature leggere");
		Privilegio priv2=serv.findByName("Armature medie");
		Privilegio priv3=serv.findByName("Armi semplici");
		Privilegio priv4=serv.findByName("Armi da guerra");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		oldPriv.add(priv2);
		oldPriv.add(priv3);
		oldPriv.add(priv4);
		p.setPrivilegi(oldPriv);
		p.setGenericValue(genval);
		
	}

	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		AbilitaService serv= new AbilitaService();
		Integer num=2;
		List<Abilita> lista= new ArrayList<Abilita>();
		lista.add(serv.findByName("Addestrare animali"));
		lista.add(serv.findByName("Atletica"));
		lista.add(serv.findByName("Intimidire"));
		lista.add(serv.findByName("Natura"));
		lista.add(serv.findByName("Percezione"));
		lista.add(serv.findByName("Sopravvivenza"));
		
		Pair<Integer,List<Abilita>> result =Pair.of(num, lista);
		return result;
	}


	@Override
	public Boolean setAbilita(Personaggio p, List<Abilita> lista) {
		AbilitaService serv= new AbilitaService();
		
		List<Abilita> listaDefault= new ArrayList<Abilita>();
		listaDefault.add(serv.findByName("Addestrare animali"));
		listaDefault.add(serv.findByName("Atletica"));
		listaDefault.add(serv.findByName("Intimidire"));
		listaDefault.add(serv.findByName("Natura"));
		listaDefault.add(serv.findByName("Percezione"));
		listaDefault.add(serv.findByName("Sopravvivenza"));
		if(lista.size()!=2||(lista.stream().anyMatch(ab->!listaDefault.contains(ab))))
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

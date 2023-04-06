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

public class Stregone implements Classe {

	@Override
	public void applicaCambiamenti(Personaggio p) {
		p.setDv("1d6");
		List<Integer> carat = p.getCaratteristiche();
		Integer modCos= (carat.get(2)-10)/2;
		p.setPf(6+modCos);
		p.setCompetenza(2);
		Map<String, String> genval= p.getGenericValue();
		genval.put("Trucchetti", "4");
		genval.put("Incantesimi", "2");
		PrivilegioService serv= new PrivilegioService();
		Privilegio priv=serv.findByName("Origine stregonesca");
		Privilegio priv1=serv.findByName("Armi semplici");
		List<Privilegio> oldPriv=p.getPrivilegi();
		oldPriv.add(priv);
		oldPriv.add(priv1);
		p.setPrivilegi(oldPriv);
		p.setGenericValue(genval);
	}

	@Override
	public Pair<Integer,List<Abilita>> abilitaPossibili() {
		AbilitaService serv= new AbilitaService();
		Integer num=2;
		List<Abilita> lista= new ArrayList<Abilita>();
		lista.add(serv.findByName("Intuizione"));
		lista.add(serv.findByName("Inganno"));
		lista.add(serv.findByName("Intimidire"));
		lista.add(serv.findByName("Religione"));
		lista.add(serv.findByName("Persuasione"));
		lista.add(serv.findByName("Arcano"));
		Pair<Integer,List<Abilita>> result =Pair.of(num, lista);
		return result;
	}

	@Override
	public Boolean setAbilita(Personaggio p, List<Abilita> lista) {
		AbilitaService serv= new AbilitaService();
		List<Abilita> listaDefault= new ArrayList<Abilita>();
		listaDefault.add(serv.findByName("Intuizione"));
		listaDefault.add(serv.findByName("Inganno"));
		listaDefault.add(serv.findByName("Intimidire"));
		listaDefault.add(serv.findByName("Religione"));
		listaDefault.add(serv.findByName("Persuasione"));
		listaDefault.add(serv.findByName("Arcano"));
		if(lista.size()!=2||(lista.stream().anyMatch(ab->!listaDefault.contains(ab))))
			return false;
		List<Abilita> oldList= p.getAbilita();
		oldList.addAll(lista);
		p.setAbilita(oldList);
		return true;
	}

	@Override
	public Pair<Integer, List<Incantesimo>> incantesimiPossibili(Integer liv) {
		
		if(liv==0) {
			Integer num=4;
			 IncantesimiService serv= new IncantesimiService();
			 List <Incantesimo> lista = serv.getByLvl(liv).stream().filter(inc->inc.getClasse().contains("Stregone")).toList();
			
			Pair<Integer,List<Incantesimo>> result =Pair.of(num, lista);
			return result;
		} 
		else if (liv==1){
			Integer num=2;
			 IncantesimiService serv= new IncantesimiService();
			 List <Incantesimo> lista = serv.getByLvl(liv).stream().filter(inc->inc.getClasse().contains("Stregone")).toList();
			
			Pair<Integer,List<Incantesimo>> result =Pair.of(num, lista);
			return result;
		} 
		else {
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
		List <Incantesimo> listaStregone = serv.getByLvl(lvl).stream().filter(inc->inc.getClasse().contains("Stregone")).toList();
		for( Incantesimo inc : lista) 
		{
			if(!listaStregone.contains(inc))
				return false;
		} 
		List<Incantesimo> oldList= p.getIncantesimi();
		oldList.addAll(lista);
		p.setIncantesimi(oldList);
		return true;
	}

	@Override
	public Boolean setModifiche(List<List<String>> risposte, Personaggio p) {
		List<String> possibiliRisposte = new ArrayList<String>();
		possibiliRisposte.add("Discendenza draconica");
		possibiliRisposte.add("Magia selvaggia");
		if (risposte == null || risposte.size()!=1 || risposte.get(0).size()!=1 || !possibiliRisposte.contains(risposte.get(0).get(0)))
			return false;
		String ris = risposte.get(0).get(0);
		Map<String, String> mappa = p.getGenericValue();
		mappa.put("Origine stregonesca", ris);
		p.setGenericValue(mappa);
		if(ris.equals("Discendenza draconica"))
			p.setPf(p.getPf()+1);
		return true;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		List<Domanda> res = new ArrayList<Domanda>();
		Domanda d = new Domanda();
		d.domanda = "Scegliere un'origine stregonesca";
		d.numeroRisposte = 1;
		d.possibiliRisposte = new ArrayList<String>();
		d.possibiliRisposte.add("Discendenza draconica");
		d.possibiliRisposte.add("Magia selvaggia");
		res.add(d);
		return res;
	}

}

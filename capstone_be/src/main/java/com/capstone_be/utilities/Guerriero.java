package com.capstone_be.utilities;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Pair;
import org.springframework.stereotype.Component;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Privilegio;
import com.capstone_be.services.AbilitaService;
import com.capstone_be.services.PrivilegioService;

@Component
public class Guerriero implements Classe {
	
	@Autowired
	PrivilegioService serv;

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
		Privilegio priv6=serv.findByName("Stile di combattimento");
		Privilegio priv7=serv.findByName("Recuperare energie");
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
		List<String> possibiliRisposte = new ArrayList<String>();
		possibiliRisposte.add("Combattere con armi possenti");
		possibiliRisposte.add("Combattere con due armi");
		possibiliRisposte.add("Difesa");
		possibiliRisposte.add("Duellare");
		possibiliRisposte.add("Protezione");
		possibiliRisposte.add("Tiro");
		if (risposte == null || risposte.size()!=1 || risposte.get(0).size()!=1 || !possibiliRisposte.contains(risposte.get(0).get(0)))
			return false;
		String ris = risposte.get(0).get(0);
		Map<String, String> mappa = p.getGenericValue();
		mappa.put("Stile di combattimento", ris);
		p.setGenericValue(mappa);
		return true;
	}

	@Override
	public List<Domanda> modificheNecessarie() {
		List<Domanda> res = new ArrayList<Domanda>();
		Domanda d = new Domanda();
		d.domanda = "Scegliere uno stile di combattimento";
		d.numeroRisposte = 1;
		d.possibiliRisposte = new ArrayList<String>();
		d.descrizioni = new ArrayList<String>();
		d.possibiliRisposte.add("Combattere con armi possenti");
		d.possibiliRisposte.add("Combattere con due armi");
		d.possibiliRisposte.add("Difesa");
		d.possibiliRisposte.add("Duellare");
		d.possibiliRisposte.add("Protezione");
		d.possibiliRisposte.add("Tiro");
		d.descrizioni.add("Quando si attacca con un'arma a due mani se in un dado dei danni si ottiene 1 o 2 è possibile ritirare una volta questo dado.");
		d.descrizioni.add("Quando si attacca con due armi si applica il modificatore di caratteristica anche sull'arma secondaria.");
		d.descrizioni.add("Finchè si indossa un'armatura, +1 CA.");
		d.descrizioni.add("Quando si attacca con un'arma a una mano e non impugna altre armi, +2 danni con quell'arma.");
		d.descrizioni.add("Se il guerriero impugna uno scudo e un'avversario in vista attacca un alleato entro 1,5 metri dal guerriero, può usare la sua reazione per applicare svantaggio all'attacco del nemico.");
		d.descrizioni.add("+2 tiro per colpire con armi a distanza");
		res.add(d);
		return res;
	}

	

}

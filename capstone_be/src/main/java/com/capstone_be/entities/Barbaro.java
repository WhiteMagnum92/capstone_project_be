package com.capstone_be.entities;

import java.util.List;
import java.util.Map;

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
		
	}

	@Override
	public List<String> abilitaPossibili() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setAbilita() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<String> incantesimiPossibili() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Boolean setIncantesimi() {
		// TODO Auto-generated method stub
		return null;
	}

}

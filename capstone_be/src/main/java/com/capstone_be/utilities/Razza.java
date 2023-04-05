package com.capstone_be.utilities;

import java.util.List;

import com.capstone_be.entities.Personaggio;

public interface Razza {
	
	public Integer id=0;//TODO non inizializzare
	public String nome=null;//TODO non inizializzareS
	
	public abstract void applicaCambiamenti(Personaggio p);
	public abstract List<Linguaggio> linguaggiPossibili();
	public abstract Boolean setLinguaggi(List<Linguaggio> lista, Personaggio p);
	public abstract Boolean setModifiche(List<List<String>> risposte, Personaggio p);
	public abstract List<Domanda>modificheNecessarie();
}
 	
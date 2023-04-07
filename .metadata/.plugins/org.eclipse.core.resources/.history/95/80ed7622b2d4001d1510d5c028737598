package com.capstone_be.utilities;

import java.util.List;

import org.springframework.data.util.Pair;

import com.capstone_be.entities.Abilita;
import com.capstone_be.entities.Incantesimo;
import com.capstone_be.entities.Personaggio;

public interface Classe {
	
	Integer id=0;//TODO non inizializzare
	String nome=null;//TODO non inizializzare
	
	public abstract void applicaCambiamenti(Personaggio p);
	public abstract Pair<Integer,List<Abilita>> abilitaPossibili();
	public abstract Boolean setAbilita(Personaggio p, List<Abilita> lista);
	public abstract Pair<Integer,List<Incantesimo>> incantesimiPossibili(Integer liv);
	public abstract Boolean setIncantesimi(Personaggio p, List<Incantesimo> lista);

}

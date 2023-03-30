package com.capstone_be.entities;

import java.util.List;
import java.util.Map;

import com.SpringBoot_SpringSecurity.entity.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaggio {
	
	Integer id;
	List<Integer> caratteristiche;
	Integer ca;
	Integer iniziativa;
	Double velocita;
	Integer competenza;
	Integer pf;
	List<String> ts;
	List<Abilita> abilita;
	String dv;
	String nome;
	Integer lvl;
	List <Razza> razza;
	String background;
	String allineamento;
	String eta;
	String taglia;
	List<Linguaggio> linguaggi;
	Integer peso;
	Integer altezza;
	String capelli;
	List<Privilegio> privilegi;
	List<Incantesimo> incantesimi;
	Classe classe;
	User user;
	Map<String, Integer> genericValue;
	
	public void aumentaLivello() {}
	
}



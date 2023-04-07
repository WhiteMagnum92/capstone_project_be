package com.capstone_be.entities;

import java.util.List;
import java.util.Map;

import com.capstone_be.utilities.Classe;
import com.capstone_be.utilities.Linguaggio;
import com.capstone_be.utilities.Razza;

import jakarta.persistence.CollectionTable;
import jakarta.persistence.Column;
import jakarta.persistence.ElementCollection;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.JoinTable;
import jakarta.persistence.ManyToMany;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapKeyColumn;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Personaggio {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	Integer id;
	@Column
	List<Integer> caratteristiche;
	@Column
	Integer ca;
	@Column
	Integer iniziativa;
	@Column
	Double velocita;
	@Column
	Integer competenza;
	@Column
	Integer pf;
	@Column
	List<String> ts;
	@ManyToMany
	@JoinTable(name = "personaggio_abilita", joinColumns = @JoinColumn(name = "personaggio_id", referencedColumnName = "id"), inverseJoinColumns = @JoinColumn(name = "abilita_id", referencedColumnName = "id"))
	List<Abilita> abilita;
	@Column
	String dv;
	@Column
	String name;
	@Column
	Integer lvl;
	@Column
	String razza;
	@Column
	String background;
	@Column
	String allineamento;
	@Column
	String eta;
	@Column
	String taglia;
	@Column
	List<Linguaggio> linguaggi;
	@Column
	Integer peso;
	@Column
	Integer altezza;
	@Column
	String capelli;
	@ManyToMany
	List<Privilegio> privilegi;
	@ManyToMany
	List<Incantesimo> incantesimi;
	@Column
	String classe;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "id_user")
	User user;
	@ElementCollection
	@CollectionTable(name = "genericvalue", joinColumns = @JoinColumn(name = "id"))
	@MapKeyColumn(name = "key")
	@Column(name = "value")
	Map<String, String> genericValue;

}

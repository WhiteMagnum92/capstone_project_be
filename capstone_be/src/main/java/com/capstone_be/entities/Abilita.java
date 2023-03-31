package com.capstone_be.entities;

import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.ManyToMany;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Data
public class Abilita {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer id;
	@Column
	String name;
	@Column
	String descrizione;
	@ManyToMany(mappedBy = "abilita")
	List<Personaggio> personaggi;

}

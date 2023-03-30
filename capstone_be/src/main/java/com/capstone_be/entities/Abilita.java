package com.capstone_be.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
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
	String nome;
	@Column
	String descrizione;

}

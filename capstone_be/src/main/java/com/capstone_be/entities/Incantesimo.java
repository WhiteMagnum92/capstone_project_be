package com.capstone_be.entities;

import java.util.List;

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
public class Incantesimo {
	
	@Id
	@GeneratedValue(strategy= GenerationType.IDENTITY)
	Integer id;
	String name;
	Integer lvl;
	List<String> classe;
	

}

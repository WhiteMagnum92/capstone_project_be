package com.capstone_be.repositories;


import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.capstone_be.entities.Incantesimo;

public interface IncantesimiRepository extends JpaRepository<Incantesimo, Integer> {
	
	List<Incantesimo> findByLvl(Integer lvl);

}

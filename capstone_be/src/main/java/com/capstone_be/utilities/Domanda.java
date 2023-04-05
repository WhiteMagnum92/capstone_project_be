package com.capstone_be.utilities;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
public class Domanda {
	
	public String domanda;
	public List<String> possibiliRisposte;
	public List<String> descrizioni;
	public Integer numeroRisposte;

}

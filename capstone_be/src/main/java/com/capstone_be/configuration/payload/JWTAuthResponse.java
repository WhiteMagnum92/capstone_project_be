package com.capstone_be.configuration.payload;

import java.util.List;

import com.capstone_be.entities.Personaggio;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class JWTAuthResponse {
	private String email;
	private Long id;
	private String username;
    private String accessToken;
    private String tokenType = "Bearer";
    private List <Personaggio> personaggi;
}

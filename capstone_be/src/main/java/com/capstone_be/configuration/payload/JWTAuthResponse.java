package com.capstone_be.configuration.payload;

import java.util.List;
import java.util.Set;

import com.capstone_be.entities.Personaggio;
import com.capstone_be.entities.Role;

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
	private String name;
	private String username;
    private String accessToken;
    private String tokenType = "Bearer";
    private Set<Role> roles;
    private List <Personaggio> personaggi;
}

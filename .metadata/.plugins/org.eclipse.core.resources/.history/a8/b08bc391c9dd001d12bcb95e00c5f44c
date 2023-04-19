package com.capstone_be.configuration;


import java.util.Arrays;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.provisioning.InMemoryUserDetailsManager;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.CorsConfigurationSource;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;

import com.capstone_be.configuration.security.JwtAuthenticationEntryPoint;
import com.capstone_be.configuration.security.JwtAuthenticationFilter;

@Configuration
@EnableMethodSecurity
public class SecurityConfig {

    private UserDetailsService userDetailsService;

    private JwtAuthenticationEntryPoint authenticationEntryPoint;

    private JwtAuthenticationFilter authenticationFilter;

    public SecurityConfig(UserDetailsService userDetailsService,
                          JwtAuthenticationEntryPoint authenticationEntryPoint,
                          JwtAuthenticationFilter authenticationFilter){
        this.userDetailsService = userDetailsService;
        this.authenticationEntryPoint = authenticationEntryPoint;
        this.authenticationFilter = authenticationFilter;
    }

    @Bean
    public static PasswordEncoder passwordEncoder(){
        return new BCryptPasswordEncoder();
    }

    @Bean
    public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
        return configuration.getAuthenticationManager();
    }

    @Bean
    SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {

    	http.cors().and().csrf().disable()
        .authorizeHttpRequests((authorize) -> authorize
        		.requestMatchers("/api/**").permitAll()//TODO da rimuovere per mettere sotto autenticazione tutte le rotte escluse le auth
                .requestMatchers("/api/auth/**").permitAll()
                .anyRequest().authenticated())
        .exceptionHandling( exception -> exception
                .authenticationEntryPoint(authenticationEntryPoint)
        ).sessionManagement( session -> session
                .sessionCreationPolicy(SessionCreationPolicy.STATELESS)
        );

    	http.addFilterBefore(authenticationFilter, UsernamePasswordAuthenticationFilter.class);

    	return http.build();
    }
  //bean per il cors
    @Bean
       public CorsConfigurationSource corsConfigurationSource() {
          CorsConfiguration configuration = new CorsConfiguration();
          configuration.setAllowedOrigins(Arrays.asList("http://localhost:4200/"));
          configuration.setAllowedMethods(Arrays.asList("GET","POST","OPTIONS","PUT","DELETE"));
          configuration.setAllowedHeaders(Arrays.asList("content-type","Authorization"));
          configuration.setAllowCredentials(true);
          UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
          source.registerCorsConfiguration("/**", configuration);
          return source;
       }

}

package com.jsBinary.BookShow.security;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.HttpMethod;
import org.springframework.security.config.Customizer;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;

import com.jsBinary.BookShow.service.UserServiceImpl;

@Configuration
@EnableWebSecurity
public class SecurityConfig {
	
	@Autowired
	private UserServiceImpl userService;
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		return http
				.cors((c) -> Customizer.withDefaults())
				.csrf((c) -> c.disable())
				.authorizeHttpRequests(
						(c) ->{c
							.requestMatchers(HttpMethod.GET, "/api/v1/book/*", "/api/v1/author/*").hasAnyRole("ADMIN", "USER")
							.requestMatchers(HttpMethod.POST, "/api/v1/book/*", "/api/v1/author/*").hasRole("ADMIN")
							.requestMatchers(HttpMethod.DELETE, "/api/v1/book/*", "/api/v1/author/*").hasRole("ADMIN")
							.requestMatchers(HttpMethod.PUT, "/api/v1/book/*", "/api/v1/author/*").hasRole("ADMIN")
//							.requestMatchers(HttpMethod.GET, "/api/v1/author/*").hasAnyRole("ADMIN", "USER")
//							.requestMatchers(HttpMethod.POST, "/api/v1/author/*").hasRole("ADMIN")
//							.requestMatchers(HttpMethod.DELETE, "/api/v1/author/*").hasRole("ADMIN")
//							.requestMatchers(HttpMethod.PUT, "/api/v1/author/*").hasRole("ADMIN")
							.anyRequest().authenticated();
						})
				.httpBasic(Customizer.withDefaults())
				.build();
				
	}
	
	@Autowired
	public void configureGlobal(AuthenticationManagerBuilder auth) throws Exception {
	
		auth.userDetailsService(userService)
		.passwordEncoder(new BCryptPasswordEncoder());
	}
	
	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

}

package com.application.config.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.builders.WebSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;

import com.application.client.view.login.LoginView;
import com.vaadin.flow.spring.security.VaadinWebSecurityConfigurerAdapter;

@EnableWebSecurity
@Configuration
public class SecurityConfiguration extends VaadinWebSecurityConfigurerAdapter {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	public static final String LOGOUT_URL = "/";

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	@Bean
	public PasswordEncoder passwordEncoder() {
		return new BCryptPasswordEncoder();
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void configure(HttpSecurity http) throws Exception {
		super.configure(http);
		this.setLoginView(http, LoginView.class, LOGOUT_URL);
	}

	@Override
	public void configure(WebSecurity web) throws Exception {
		super.configure(web);
		// TODO JT : TEST
		web.ignoring().antMatchers("/images/*.png", "/images/*.jpg");
	}

}

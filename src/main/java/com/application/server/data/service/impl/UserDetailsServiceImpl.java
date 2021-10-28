package com.application.server.data.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.application.data.service.UserRepository;
import com.application.server.data.entity.User;

import utils.CollectionUtils;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	public static final String ROLE_PREFIX = "ROLE_";

	@Autowired
	private UserRepository userRepository;

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		final User user = this.userRepository.findByLogin(username);
		if (user == null) {
			throw new UsernameNotFoundException("No user present with username: " + username);
		} else {
			return new org.springframework.security.core.userdetails.User(user.getLogin(), user.getPassword(),
					this.getAuthorities(user));
		}
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	private List<GrantedAuthority> getAuthorities(User user) {
		return CollectionUtils.asList(new SimpleGrantedAuthority(ROLE_PREFIX + user.getType().getValueAsString()));
	}

}

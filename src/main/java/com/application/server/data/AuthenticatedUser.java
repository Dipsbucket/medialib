package com.application.server.data;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Component;

import com.application.data.service.UserRepository;
import com.application.security.SecurityConfiguration;
import com.application.server.data.entity.User;
import com.vaadin.flow.component.UI;
import com.vaadin.flow.server.VaadinServletRequest;

@Component
public class AuthenticatedUser {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	@Autowired
	private UserRepository userRepository;

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	private UserDetails getAuthenticatedUser() {
		final SecurityContext context = SecurityContextHolder.getContext();
		final Object principal = context.getAuthentication().getPrincipal();
		if (principal instanceof UserDetails) {
			final UserDetails userDetails = (UserDetails) context.getAuthentication().getPrincipal();
			return userDetails;
		}

		return null;
	}

	public Optional<User> get() {
		final UserDetails details = this.getAuthenticatedUser();
		if (details == null) {
			return Optional.empty();
		}

		return Optional.of(this.userRepository.findByLogin(details.getUsername()));
	}

	public void logout() {
		UI.getCurrent().getPage().setLocation(SecurityConfiguration.LOGOUT_URL);
		final SecurityContextLogoutHandler logoutHandler = new SecurityContextLogoutHandler();
		logoutHandler.logout(VaadinServletRequest.getCurrent().getHttpServletRequest(), null, null);
	}

}

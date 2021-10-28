package com.application.server.data.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.application.data.service.UserRepository;
import com.application.server.data.entity.User;

@Service
public class UserService extends CrudService<User, Integer> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private final UserRepository repository;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public UserService(@Autowired UserRepository repository) {
		this.repository = repository;
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected UserRepository getRepository() {
		return this.repository;
	}

}

package com.application.server.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.vaadin.artur.helpers.CrudService;

import com.application.server.repository.AbstractJpaRepository;

@Service
public abstract class AbstractCrudService<T> extends CrudService<T, Integer> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	protected final AbstractJpaRepository<T> repository;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractCrudService(@Autowired AbstractJpaRepository<T> repository) {
		this.repository = repository;
	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public List<T> findAll() {
		return this.getRepository().findAll();
	}

}

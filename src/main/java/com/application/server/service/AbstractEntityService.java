package com.application.server.service;

import com.application.server.data.entity.AbstractEntity;
import com.application.server.repository.AbstractJpaRepository;

public abstract class AbstractEntityService<T extends AbstractEntity> extends AbstractCrudService<T> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntityService(AbstractJpaRepository<T> repository) {
		super(repository);
	}

}

package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Documentary;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.DocumentaryRepository;

import utils.CastUtils;

@Service
public class DocumentaryService extends AbstractCrudService<Documentary> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public DocumentaryService(AbstractJpaRepository<Documentary> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected DocumentaryRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

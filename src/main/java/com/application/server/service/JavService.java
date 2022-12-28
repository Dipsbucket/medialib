package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Jav;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.JavRepository;

import utils.CastUtils;

@Service
public class JavService extends AbstractEntityService<Jav> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public JavService(AbstractJpaRepository<Jav> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected JavRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

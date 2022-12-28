package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Spectacle;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.SpectacleRepository;

import utils.CastUtils;

@Service
public class SpectacleService extends AbstractEntityService<Spectacle> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public SpectacleService(AbstractJpaRepository<Spectacle> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected SpectacleRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

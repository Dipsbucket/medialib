package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Pornstar;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.PornstarRepository;

import utils.CastUtils;

@Service
public class PornstarService extends AbstractEntityService<Pornstar> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public PornstarService(AbstractJpaRepository<Pornstar> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected PornstarRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

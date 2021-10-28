package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Hentai;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.HentaiRepository;

import utils.CastUtils;

@Service
public class HentaiService extends AbstractCrudService<Hentai> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiService(AbstractJpaRepository<Hentai> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected HentaiRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

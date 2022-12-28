package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.HentaiAnime;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.HentaiAnimeRepository;

import utils.CastUtils;

@Service
public class HentaiAnimeService extends AbstractEntityService<HentaiAnime> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiAnimeService(AbstractJpaRepository<HentaiAnime> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected HentaiAnimeRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.HentaiArtist;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.HentaiArtistRepository;

import utils.CastUtils;

@Service
public class HentaiArtistService extends AbstractEntityService<HentaiArtist> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiArtistService(AbstractJpaRepository<HentaiArtist> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected HentaiArtistRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

package com.application.server.service;

import org.springframework.stereotype.Service;

import com.application.server.data.entity.Movie;
import com.application.server.repository.AbstractJpaRepository;
import com.application.server.repository.MovieRepository;

import utils.CastUtils;

@Service
public class MovieService extends AbstractCrudService<Movie> {

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MovieService(AbstractJpaRepository<Movie> repository) {
		super(repository);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected MovieRepository getRepository() {
		return CastUtils.uncheckedCast(this.repository);
	}

}

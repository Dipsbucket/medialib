package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.MovieObjectView;
import com.application.server.data.entity.Movie;
import com.application.server.service.MovieService;

import utils.CastUtils;

@Component
public class MovieImageGridPresenter extends AbstractEntityImageGridPresenter<Movie> {

	public interface MovieImageGridDisplay extends AbstractEntityImageGridDisplay<Movie> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MovieImageGridPresenter(MovieService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public MovieImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected MovieObjectView createEntityObjectView() {
		return new MovieObjectView(this.getView().getContext());
	}

}

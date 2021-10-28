package com.application.client.view;

import javax.annotation.security.PermitAll;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.MovieImageGridPresenter.MovieImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Movie;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Movies")
@Route(value = "movies", layout = MainLayout.class)
@PermitAll
@Tag("movie-view")
@JsModule("./views/movie-view.ts")
public class MovieImageGridView extends AbstractEntityImageGridView<Movie> implements MovieImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MovieImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected String getContext() {
		return ContextConstants.MOVIE_CONTEXT;
	}

	@Override
	protected String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_MOVIE;
	}

}

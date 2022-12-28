package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.Movie;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class MovieObjectView extends AbstractEntityObjectView<Movie> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = 2466006807515250824L;

	private TextField nameField;
	private TextField nameEnField;
	private TextField nameFrField;
	private DatePicker releaseDateField;
	private NumberField ratingField;
	private Checkbox watchedField;
	private Checkbox ownedField;
	private Checkbox likedField;
	private TextField linkField;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MovieObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<Movie>(Movie.class);
	}

	@Override
	protected void initFields() {
		this.nameField = ComponentFactory.createMovieNameField();
		this.nameEnField = ComponentFactory.createMovieNameEnField();
		this.nameFrField = ComponentFactory.createMovieNameFrField();
		this.releaseDateField = ComponentFactory.createReleaseDateField();
		this.ratingField = ComponentFactory.createRatingField();
		this.watchedField = ComponentFactory.createWatchedField();
		this.ownedField = ComponentFactory.createOwnedField();
		this.likedField = ComponentFactory.createLikedField();
		this.linkField = ComponentFactory.createLinkField();

		this.addFields(this.nameField, this.nameEnField, this.nameFrField, this.releaseDateField, this.ratingField,
				this.watchedField, this.ownedField, this.likedField, this.linkField);
	}

	@Override
	protected void bindFields() {
		this.binder.forField(this.nameField).bind(Movie::getName, null);
		this.binder.forField(this.nameEnField).bind(Movie::getNameEn, null);
		this.binder.forField(this.nameFrField).bind(Movie::getNameFr, null);
		this.binder.forField(this.releaseDateField).bind(Movie::getReleaseDateAsLocalDate, null);
		this.binder.forField(this.ratingField).bind(Movie::getRatingAsDouble, null);
		this.binder.forField(this.watchedField).bind(Movie::getWatchedAsBoolean, null);
		this.binder.forField(this.ownedField).bind(Movie::getOwnedAsBoolean, null);
		this.binder.forField(this.likedField).bind(Movie::getLikedAsBoolean, null);
		this.binder.forField(this.linkField).bind(Movie::getLink, null);
	}

}

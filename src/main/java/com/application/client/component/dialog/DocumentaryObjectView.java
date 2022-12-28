package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.Documentary;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class DocumentaryObjectView extends AbstractEntityObjectView<Documentary> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -641309524244336119L;

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

	public DocumentaryObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<Documentary>(Documentary.class);
		this.binder.setBean(this.data);
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
		this.binder.forField(this.nameField).bind(Documentary::getName, null);
		this.binder.forField(this.nameEnField).bind(Documentary::getNameEn, null);
		this.binder.forField(this.nameFrField).bind(Documentary::getNameFr, null);
		this.binder.forField(this.releaseDateField).bind(Documentary::getReleaseDateAsLocalDate, null);
		this.binder.forField(this.ratingField).bind(Documentary::getRatingAsDouble, null);
		this.binder.forField(this.watchedField).bind(Documentary::getWatchedAsBoolean, null);
		this.binder.forField(this.ownedField).bind(Documentary::getOwnedAsBoolean, null);
		this.binder.forField(this.likedField).bind(Documentary::getLikedAsBoolean, null);
		this.binder.forField(this.linkField).bind(Documentary::getLink, null);
	}

}

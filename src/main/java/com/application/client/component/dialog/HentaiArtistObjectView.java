package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.HentaiArtist;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class HentaiArtistObjectView extends AbstractEntityObjectView<HentaiArtist> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -8751242516340176385L;

	private TextField nameField;
	private IntegerField bookCountField;
	private TextField linkField;
	private TextField dowloadLinkField;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiArtistObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<HentaiArtist>(HentaiArtist.class);
		this.binder.setBean(this.data);
	}

	@Override
	protected void initFields() {
		this.nameField = ComponentFactory.createPersonNameField();
		this.bookCountField = ComponentFactory.createBookCountField();
		this.linkField = ComponentFactory.createLinkField();
		this.dowloadLinkField = ComponentFactory.createDownloadLinkField();

		this.addFields(this.nameField, this.bookCountField, this.linkField, this.dowloadLinkField);
	}

	@Override
	protected void bindFields() {
		this.binder.forField(this.nameField).bind(HentaiArtist::getName, null);
		this.binder.forField(this.bookCountField).bind(HentaiArtist::getBookCount, null);
		this.binder.forField(this.linkField).bind(HentaiArtist::getLink, null);
		this.binder.forField(this.dowloadLinkField).bind(HentaiArtist::getDownloadLink, null);
	}

}

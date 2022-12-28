package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.HentaiAnime;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class HentaiAnimeObjectView extends AbstractEntityObjectView<HentaiAnime> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -663923130790265711L;

	private TextField nameField;
	private TextField nameEnField;
	private IntegerField episodeCountField;
	private Checkbox runningField;
	private Checkbox watchedField;
	private Checkbox ownedField;
	private TextField linkField;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiAnimeObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<HentaiAnime>(HentaiAnime.class);
		this.binder.setBean(this.data);
	}

	@Override
	protected void initFields() {
		this.nameField = ComponentFactory.createMovieNameField();
		this.nameEnField = ComponentFactory.createMovieNameEnField();
		this.episodeCountField = ComponentFactory.createEpisodeCountField();
		this.runningField = ComponentFactory.createRunningField();
		this.watchedField = ComponentFactory.createWatchedField();
		this.ownedField = ComponentFactory.createOwnedField();
		this.linkField = ComponentFactory.createLinkField();

		this.addFields(this.nameField, this.nameEnField, this.episodeCountField, this.runningField, this.watchedField,
				this.ownedField, this.linkField);
	}

	@Override
	protected void bindFields() {
		this.binder.forField(this.nameField).bind(HentaiAnime::getName, null);
		this.binder.forField(this.nameEnField).bind(HentaiAnime::getNameEn, null);
		this.binder.forField(this.episodeCountField).bind(HentaiAnime::getEpisodeCount, null);
		this.binder.forField(this.runningField).bind(HentaiAnime::getRunningAsBoolean, null);
		this.binder.forField(this.watchedField).bind(HentaiAnime::getWatchedAsBoolean, null);
		this.binder.forField(this.ownedField).bind(HentaiAnime::getOwnedAsBoolean, null);
		this.binder.forField(this.linkField).bind(HentaiAnime::getLink, null);
	}

}

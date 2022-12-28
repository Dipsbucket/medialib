package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.Jav;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class JavObjectView extends AbstractEntityObjectView<Jav> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = 3642627367433201456L;

	private TextField nameField;
	private TextField idolsField;
	private Checkbox watchedField;
	private Checkbox ownedField;
	private TextField linkField;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public JavObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<Jav>(Jav.class);
		this.binder.setBean(this.data);
	}

	@Override
	protected void initFields() {
		this.nameField = ComponentFactory.createPersonNameField();
		this.idolsField = ComponentFactory.createIdolsField();
		this.watchedField = ComponentFactory.createWatchedField();
		this.ownedField = ComponentFactory.createOwnedField();
		this.linkField = ComponentFactory.createLinkField();

		this.addFields(this.nameField, this.idolsField, this.watchedField, this.ownedField, this.linkField);
	}

	@Override
	protected void bindFields() {
		this.binder.forField(this.nameField).bind(Jav::getName, null);
		this.binder.forField(this.idolsField).bind(Jav::getIdols, null);
		this.binder.forField(this.watchedField).bind(Jav::getWatchedAsBoolean, null);
		this.binder.forField(this.ownedField).bind(Jav::getOwnedAsBoolean, null);
		this.binder.forField(this.linkField).bind(Jav::getLink, null);
	}

}

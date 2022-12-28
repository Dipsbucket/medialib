package com.application.client.component.dialog;

import com.application.client.component.ComponentFactory;
import com.application.server.data.entity.Pornstar;
import com.application.server.data.entity.Pornstar.PornstarEthnicity;
import com.application.server.data.entity.Pornstar.PornstarStatus;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.textfield.TextField;
import com.vaadin.flow.data.binder.Binder;

public class PornstarObjectView extends AbstractEntityObjectView<Pornstar> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -5420081852470800201L;

	private TextField nameField;
	private ComboBox<PornstarStatus> statusField;
	private ComboBox<PornstarEthnicity> ethnicityField;
	private TextField typeField;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public PornstarObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void initBinder() {
		this.binder = new Binder<Pornstar>(Pornstar.class);
		this.binder.setBean(this.data);
	}

	@Override
	protected void initFields() {
		this.nameField = ComponentFactory.createPersonNameField();
		this.statusField = ComponentFactory.createPornstarStatusField();
		this.ethnicityField = ComponentFactory.createPornstarEthnicityField();
		this.typeField = ComponentFactory.createTypeField();

		this.addFields(this.nameField, this.statusField, this.ethnicityField, this.typeField);
	}

	@Override
	protected void bindFields() {
		this.binder.forField(this.nameField).bind(Pornstar::getName, null);
		this.binder.forField(this.statusField).bind(Pornstar::getStatus, null);
		this.binder.forField(this.ethnicityField).bind(Pornstar::getEthnicity, null);
		this.binder.forField(this.typeField).bind(Pornstar::getType, null);
	}

}

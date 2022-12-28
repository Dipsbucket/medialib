package com.application.client.component.dialog;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.application.client.constant.StyleConstants;
import com.vaadin.flow.component.AbstractField;
import com.vaadin.flow.component.dialog.Dialog;
import com.vaadin.flow.component.formlayout.FormLayout;
import com.vaadin.flow.data.binder.Binder;

public abstract class AbstractObjectView<T> extends Dialog {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = 1258764268287443379L;

	protected String context;
	protected T data;
	protected Binder<T> binder;
	protected List<AbstractField<?, ?>> fields;
	protected FormLayout formLayout;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractObjectView(String context) {
		this.context = context;
		this.setModal(true);

		this.initBinder();
		this.initFields();
		this.bind();
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	protected abstract void initBinder();

	protected abstract void initFields();

	protected abstract void bindFields();

	protected void bind() {
		this.bindFields();
	}

	protected void buildLayout() {
		this.removeAll();
		this.buildFormLayout();
		this.add(this.formLayout);
	}

	protected void buildFormLayout() {
		this.formLayout = new FormLayout();
		this.formLayout.setMaxWidth(StyleConstants.CSS_FORM_MAX_WIDTH);
		this.getFields().stream().forEach(field -> this.formLayout.add(field));
	}

	public void setData(T data) {
		this.data = data;

		this.binder.setBean(data);
		this.buildLayout();
	}

	protected void addField(AbstractField<?, ?> field) {
		this.getFields().add(field);
	}

	protected void addFields(AbstractField<?, ?>... fields) {
		this.getFields().addAll(Arrays.asList(fields));
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public void setContext(String context) {
		this.context = context;
	}

	public List<AbstractField<?, ?>> getFields() {
		if (this.fields == null) {
			this.fields = new ArrayList<AbstractField<?, ?>>();
		}

		return this.fields;
	}

}

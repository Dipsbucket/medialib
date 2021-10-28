package com.application.client.view;

import javax.annotation.security.PermitAll;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.DocumentaryImageGridPresenter.DocumentaryImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Documentary;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Documentaries")
@Route(value = "documentaries", layout = MainLayout.class)
@PermitAll
@Tag("documentary-view")
@JsModule("./views/documentary-view.ts")
public class DocumentaryImageGridView extends AbstractEntityImageGridView<Documentary>
		implements DocumentaryImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public DocumentaryImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected String getContext() {
		return ContextConstants.DOCUMENTARY_CONTEXT;
	}

	@Override
	protected String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_DOCUMENTARY;
	}

}

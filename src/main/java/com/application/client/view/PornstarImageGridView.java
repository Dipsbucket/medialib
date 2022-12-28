package com.application.client.view;

import javax.annotation.security.RolesAllowed;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.PornstarImageGridPresenter.PornstarImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Pornstar;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Pornstars")
@Route(value = "pornstars", layout = MainLayout.class)
@RolesAllowed("admin")
@Tag("pornstar-view")
@JsModule("./views/pornstar-view.ts")
public class PornstarImageGridView extends AbstractEntityImageGridView<Pornstar> implements PornstarImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public PornstarImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public String getContext() {
		return ContextConstants.PORNSTAR_CONTEXT;
	}

	@Override
	public String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_PORNSTAR;
	}

}

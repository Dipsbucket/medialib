package com.application.client.view;

import javax.annotation.security.PermitAll;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.SpectacleImageGridPresenter.SpectacleImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Spectacle;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Spectacles")
@Route(value = "spectacles", layout = MainLayout.class)
@PermitAll
@Tag("spectacle-view")
@JsModule("./views/spectacle-view.ts")
public class SpectacleImageGridView extends AbstractEntityImageGridView<Spectacle>
		implements SpectacleImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public SpectacleImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public String getContext() {
		return ContextConstants.SPECTACLE_CONTEXT;
	}

	@Override
	public String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_SPECTACLE;
	}

}

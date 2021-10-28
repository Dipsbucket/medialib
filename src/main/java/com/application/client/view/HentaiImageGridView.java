package com.application.client.view;

import javax.annotation.security.RolesAllowed;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.HentaiImageGridPresenter.HentaiImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Hentai;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Hentais")
@Route(value = "hentais", layout = MainLayout.class)
@RolesAllowed("admin")
@Tag("hentai-view")
@JsModule("./views/hentai-view.ts")
public class HentaiImageGridView extends AbstractEntityImageGridView<Hentai> implements HentaiImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected String getContext() {
		return ContextConstants.HENTAI_CONTEXT;
	}

	@Override
	protected String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_HENTAI;
	}

}

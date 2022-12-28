package com.application.client.view;

import javax.annotation.security.RolesAllowed;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.HentaiArtistImageGridPresenter.HentaiArtistImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.HentaiArtist;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Hentai Artists")
@Route(value = "hentai_artists", layout = MainLayout.class)
@RolesAllowed("admin")
@Tag("hentai-artist-view")
@JsModule("./views/hentai-artist-view.ts")
public class HentaiArtistImageGridView extends AbstractEntityImageGridView<HentaiArtist>
		implements HentaiArtistImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiArtistImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public String getContext() {
		return ContextConstants.HENTAI_ARTIST_CONTEXT;
	}

	@Override
	public String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_HENTAI_ARTIST;
	}

}

package com.application.client.view;

import javax.annotation.security.RolesAllowed;

import com.application.client.constant.StyleConstants;
import com.application.client.presenter.HentaiAnimeImageGridPresenter.HentaiAnimeImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.HentaiAnime;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Anime Hentais")
@Route(value = "anime_hentais", layout = MainLayout.class)
@RolesAllowed("admin")
@Tag("hentai-anime-view")
@JsModule("./views/hentai-anime-view.ts")
public class HentaiAnimeImageGridView extends AbstractEntityImageGridView<HentaiAnime>
		implements HentaiAnimeImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiAnimeImageGridView() {
		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public String getContext() {
		return ContextConstants.HENTAI_ANIME_CONTEXT;
	}

	@Override
	public String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_HENTAI_ANIME;
	}

}

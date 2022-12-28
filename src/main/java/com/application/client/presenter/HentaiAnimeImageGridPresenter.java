package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.HentaiAnimeObjectView;
import com.application.server.data.entity.HentaiAnime;
import com.application.server.service.HentaiAnimeService;

import utils.CastUtils;

@Component
public class HentaiAnimeImageGridPresenter extends AbstractEntityImageGridPresenter<HentaiAnime> {

	public interface HentaiAnimeImageGridDisplay extends AbstractEntityImageGridDisplay<HentaiAnime> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiAnimeImageGridPresenter(HentaiAnimeService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public HentaiAnimeImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected HentaiAnimeObjectView createEntityObjectView() {
		return new HentaiAnimeObjectView(this.getView().getContext());
	}

}

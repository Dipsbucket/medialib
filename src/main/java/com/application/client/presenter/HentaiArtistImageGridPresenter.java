package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.HentaiArtistObjectView;
import com.application.server.data.entity.HentaiArtist;
import com.application.server.service.HentaiArtistService;

import utils.CastUtils;

@Component
public class HentaiArtistImageGridPresenter extends AbstractEntityImageGridPresenter<HentaiArtist> {

	public interface HentaiArtistImageGridDisplay extends AbstractEntityImageGridDisplay<HentaiArtist> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiArtistImageGridPresenter(HentaiArtistService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public HentaiArtistImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected HentaiArtistObjectView createEntityObjectView() {
		return new HentaiArtistObjectView(this.getView().getContext());
	}

}

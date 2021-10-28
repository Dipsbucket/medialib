package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.server.data.entity.Hentai;
import com.application.server.service.HentaiService;

import utils.CastUtils;

@Component
public class HentaiImageGridPresenter extends AbstractEntityImageGridPresenter<Hentai> {

	public interface HentaiImageGridDisplay extends AbstractEntityImageGridDisplay<Hentai> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HentaiImageGridPresenter(HentaiService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public HentaiImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

}

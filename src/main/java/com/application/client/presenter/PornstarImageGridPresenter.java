package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.server.data.entity.Pornstar;
import com.application.server.service.PornstarService;

import utils.CastUtils;

@Component
public class PornstarImageGridPresenter extends AbstractEntityImageGridPresenter<Pornstar> {

	public interface PornstarImageGridDisplay extends AbstractEntityImageGridDisplay<Pornstar> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public PornstarImageGridPresenter(PornstarService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public PornstarImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

}

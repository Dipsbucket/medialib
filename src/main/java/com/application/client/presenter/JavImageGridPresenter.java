package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.JavObjectView;
import com.application.server.data.entity.Jav;
import com.application.server.service.JavService;

import utils.CastUtils;

@Component
public class JavImageGridPresenter extends AbstractEntityImageGridPresenter<Jav> {

	public interface JavImageGridDisplay extends AbstractEntityImageGridDisplay<Jav> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public JavImageGridPresenter(JavService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public JavImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected JavObjectView createEntityObjectView() {
		return new JavObjectView(this.getView().getContext());
	}

}

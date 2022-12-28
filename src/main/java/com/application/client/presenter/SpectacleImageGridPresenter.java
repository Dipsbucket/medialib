package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.SpectacleObjectView;
import com.application.server.data.entity.Spectacle;
import com.application.server.service.SpectacleService;

import utils.CastUtils;

@Component
public class SpectacleImageGridPresenter extends AbstractEntityImageGridPresenter<Spectacle> {

	public interface SpectacleImageGridDisplay extends AbstractEntityImageGridDisplay<Spectacle> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public SpectacleImageGridPresenter(SpectacleService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public SpectacleImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected SpectacleObjectView createEntityObjectView() {
		return new SpectacleObjectView(this.getView().getContext());
	}

}

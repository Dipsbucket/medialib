package com.application.client.presenter;

import org.springframework.stereotype.Component;

import com.application.client.component.dialog.DocumentaryObjectView;
import com.application.server.data.entity.Documentary;
import com.application.server.service.DocumentaryService;

import utils.CastUtils;

@Component
public class DocumentaryImageGridPresenter extends AbstractEntityImageGridPresenter<Documentary> {

	public interface DocumentaryImageGridDisplay extends AbstractEntityImageGridDisplay<Documentary> {

	}

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public DocumentaryImageGridPresenter(DocumentaryService service) {
		super(service);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public DocumentaryImageGridDisplay getView() {
		return CastUtils.uncheckedCast(this.view);
	}

	@Override
	protected DocumentaryObjectView createEntityObjectView() {
		return new DocumentaryObjectView(this.getView().getContext());
	}

}

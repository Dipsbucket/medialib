package com.application.client.view;

import com.application.client.component.ImageContainer;
import com.application.client.presenter.AbstractEntityImageGridPresenter.AbstractEntityImageGridDisplay;
import com.application.server.data.entity.AbstractEntity;
import com.application.server.utils.ContextUtils;

import utils.CollectionUtils;

public abstract class AbstractEntityImageGridView<T extends AbstractEntity> extends AbstractImageGridView<T>
		implements AbstractEntityImageGridDisplay<T> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = 4067063801468253219L;

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public void buildComponents() {
		if (CollectionUtils.collectionNotNullOrEmpty(this.data)) {
			ImageContainer imageContainer = null;
			for (final T datum : this.data) {
				imageContainer = new ImageContainer(datum.getName(),
						ContextUtils.getImagePath(this.getContext(), datum.getPath()), datum.getName());
				this.add(imageContainer);
			}
		}
	}

}

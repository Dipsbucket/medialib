package com.application.client.view;

import java.util.ArrayList;
import java.util.List;

import com.application.client.component.ImageContainer;
import com.application.client.constant.HtmlConstants;
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

	private List<ImageContainer> imageContainerList;

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
				imageContainer.getElement().setAttribute(HtmlConstants.HTML_ATTRIBUTE_KEY_NAME, datum.getName());
				this.add(imageContainer);
				this.getImageContainerList().add(imageContainer);
			}
		}
	}

	@Override
	public List<ImageContainer> getImageContainerList() {
		if (this.imageContainerList == null) {
			this.imageContainerList = new ArrayList<ImageContainer>();
		}

		return this.imageContainerList;
	}

}

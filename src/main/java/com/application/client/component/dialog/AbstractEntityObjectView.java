package com.application.client.component.dialog;

import com.application.client.component.ImageContainer;
import com.application.server.data.entity.AbstractEntity;
import com.application.server.utils.ContextUtils;
import com.vaadin.flow.component.orderedlayout.HorizontalLayout;

public abstract class AbstractEntityObjectView<T extends AbstractEntity> extends AbstractObjectView<T> {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -4997149270150356698L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public AbstractEntityObjectView(String context) {
		super(context);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void buildLayout() {
		this.removeAll();

		HorizontalLayout horizontalLayout = new HorizontalLayout();

		// Image
		ImageContainer imageContainer = new ImageContainer(this.data.getName(),
				ContextUtils.getImagePath(this.context, this.data.getPath()), this.data.getName());
		imageContainer.hideHeader();
		horizontalLayout.add(imageContainer);

		// Formulaire
		this.buildFormLayout();
		horizontalLayout.add(this.formLayout);

		this.add(horizontalLayout);
	}

}

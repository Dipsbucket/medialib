package com.application.client.view;

import javax.annotation.security.PermitAll;

import com.application.client.component.JavImageContainer;
import com.application.client.constant.HtmlConstants;
import com.application.client.constant.StyleConstants;
import com.application.client.presenter.JavImageGridPresenter.JavImageGridDisplay;
import com.application.server.constant.ContextConstants;
import com.application.server.data.entity.Jav;
import com.application.server.utils.ContextUtils;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Div;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

import utils.CollectionUtils;

@PageTitle("Jav")
@Route(value = "jav", layout = MainLayout.class)
@PermitAll
@Tag("jav-view")
@JsModule("./views/jav-view.ts")
public class JavImageGridView extends AbstractEntityImageGridView<Jav> implements JavImageGridDisplay {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2153470948449480780L;

	private Div javContainer;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public JavImageGridView() {
		this.initJavContainer();

		// TODO JT : TEST >
		this.sortBy.setItems("Name", "Status", "Ethnicity", "Type");
		this.sortBy.setValue("Name");
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	private void initJavContainer() {
		this.javContainer = new Div();
		this.javContainer.addClassNames(StyleConstants.CSS_CLASS_DISPLAY_FLEX,
				StyleConstants.CSS_CLASS_FLEX_DIRECTION_ROW, StyleConstants.CSS_CLASS_GAP_MEDIUM,
				StyleConstants.CSS_CLASS_FLEX_WRAP_WRAP);
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	public String getContext() {
		return ContextConstants.JAV_CONTEXT;
	}

	@Override
	public String getStyleClassName() {
		return StyleConstants.CSS_VIEW_CLASS_NAME_JAV;
	}

	@Override
	public void buildComponents() {
		if (CollectionUtils.collectionNotNullOrEmpty(this.data)) {
			JavImageContainer imageContainer = null;
			for (final Jav datum : this.data) {
				imageContainer = new JavImageContainer(datum.getName(),
						ContextUtils.getImagePath(this.getContext(), datum.getPath()), datum.getName());
				imageContainer.getElement().setAttribute(HtmlConstants.HTML_ATTRIBUTE_KEY_NAME, datum.getName());
				this.getImageContainerList().add(imageContainer);
				this.javContainer.add(imageContainer);
			}

			this.add(this.javContainer);
		}
	}

}

package com.application.client.component;

import com.application.client.constant.StyleConstants;
import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

@JsModule("./components/default-image-container.ts")
@Tag("default-image-container")
public class ImageContainer extends LitTemplate {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -8953347885626653620L;

	@Id
	private Image image;

	@Id
	private Span header;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public ImageContainer(String title, String url, String text) {
		this.image.setSrc(url);
		this.image.setAlt(text);
		this.image.addClassName(StyleConstants.CSS_CLASS_SIZING_FULL_PARENT_HEIGHT);
		this.header.setText(title);
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	public void hideHeader() {
		this.header.getStyle().set(StyleConstants.CSS_PROPERTY_DISPLAY_KEY,
				StyleConstants.CSS_PROPERTY_DISPLAY_VALUE_NONE);
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public Image getImage() {
		return this.image;
	}

}

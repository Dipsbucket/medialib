package com.application.client.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;

@JsModule("./components/jav-image-container.ts")
@Tag("jav-image-container")
public class JavImageContainer extends ImageContainer {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -2049079490900413716L;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public JavImageContainer(String title, String url, String text) {
		super(title, url, text);
	}

}

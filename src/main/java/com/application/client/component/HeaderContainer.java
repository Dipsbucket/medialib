package com.application.client.component;

import com.application.client.constant.StyleConstants;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.Header;

public class HeaderContainer extends Header {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = -5510286443796398772L;

	private H1 viewTitle;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public HeaderContainer() {
		// DrawerToggle
		final DrawerToggle toggle = new DrawerToggle();
		toggle.addClassName(StyleConstants.CSS_CLASS_TEXT_COLOR_SECONDARY);
		toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		toggle.getElement().setAttribute(StyleConstants.CSS_ATTRIBUTE_ARIA_LABEL_KEY,
				StyleConstants.CSS_ATTRIBUTE_ARIA_LABEL_VALUE_MENU_TOGGLE);

		// View Title
		this.viewTitle = new H1();
		this.viewTitle.addClassNames(StyleConstants.CSS_CLASS_MARGIN_0, StyleConstants.CSS_CLASS_FONT_SIZE_LARGE);

		this.add(toggle, this.viewTitle);
		this.addClassNames(StyleConstants.CSS_CLASS_BACKGROUND_COLOR_BASE, StyleConstants.CSS_CLASS_BORDER_BOTTOM,
				StyleConstants.CSS_CLASS_BORDER_COLOR_CONTRAST_10, StyleConstants.CSS_CLASS_BOX_BORDER,
				StyleConstants.CSS_CLASS_DISPLAY_FLEX, StyleConstants.CSS_CLASS_SIZING_EXTRA_LARGE_HEIGHT,
				StyleConstants.CSS_CLASS_ALIGN_FLEX_ITEMS_CENTER, StyleConstants.CSS_CLASS_SIZING_FULL_PARENT_WIDTH);
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public H1 getViewTitle() {
		return this.viewTitle;
	}

}

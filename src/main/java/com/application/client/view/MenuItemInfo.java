package com.application.client.view;

import com.vaadin.flow.component.Component;

public class MenuItemInfo {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private String text;
	private String iconClass;
	private Class<? extends Component> view;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MenuItemInfo() {

	}

	public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
		this.text = text;
		this.iconClass = iconClass;
		this.view = view;
	}

	// ***********************************************************************************************************
	// Section de code : Accesseurs
	// ***********************************************************************************************************

	public String getText() {
		return this.text;
	}

	public String getIconClass() {
		return this.iconClass;
	}

	public Class<? extends Component> getView() {
		return this.view;
	}

}

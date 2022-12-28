package com.application.client.view.about;

import javax.annotation.security.RolesAllowed;

import com.application.client.view.MainLayout;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.orderedlayout.VerticalLayout;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("About")
@Route(value = "about", layout = MainLayout.class)
@RolesAllowed("admin")
public class AboutView extends VerticalLayout {

	private static final long serialVersionUID = -208356150591967641L;

	public AboutView() {
		this.setSpacing(false);

		Image img = new Image("images/empty-plant.png", "placeholder plant");
		img.setWidth("200px");
		this.add(img);

		this.add(new H2("This place intentionally left empty"));
		this.add(new Paragraph("It’s a place where you can grow your own UI 🤗"));

		this.setSizeFull();
		this.setJustifyContentMode(JustifyContentMode.CENTER);
		this.setDefaultHorizontalComponentAlignment(Alignment.CENTER);
		this.getStyle().set("text-align", "center");
	}

}

package com.application.client.component;

import com.vaadin.flow.component.Tag;
import com.vaadin.flow.component.dependency.JsModule;
import com.vaadin.flow.component.html.Image;
import com.vaadin.flow.component.html.Paragraph;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.littemplate.LitTemplate;
import com.vaadin.flow.component.template.Id;

@JsModule("./components/image-card.ts")
@Tag("image-card")
public class ImageCard extends LitTemplate {

	// TODO JT : TEST
	private static final long serialVersionUID = -2074914814240520454L;

	@Id
	private Image image;

	@Id
	private Span header;

	@Id
	private Span subtitle;

	@Id
	private Paragraph text;

	@Id
	private Span badge;

	public ImageCard(String text, String url) {
		this.image.setSrc(url);
		this.image.setAlt(text);
		this.header.setText("Title");
		this.subtitle.setText("Card subtitle");
		this.text.setText(
				"Lorem ipsum dolor sit amet, consectetur adipisicing elit, sed do eiusmod tempor incididunt ut.");
		this.badge.setText("Label");
	}

}

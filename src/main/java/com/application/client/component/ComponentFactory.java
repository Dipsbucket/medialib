package com.application.client.component;

import com.application.server.data.entity.Pornstar;
import com.application.server.data.entity.Pornstar.PornstarEthnicity;
import com.application.server.data.entity.Pornstar.PornstarStatus;
import com.vaadin.flow.component.checkbox.Checkbox;
import com.vaadin.flow.component.combobox.ComboBox;
import com.vaadin.flow.component.datepicker.DatePicker;
import com.vaadin.flow.component.icon.VaadinIcon;
import com.vaadin.flow.component.textfield.IntegerField;
import com.vaadin.flow.component.textfield.NumberField;
import com.vaadin.flow.component.textfield.TextField;

public class ComponentFactory {

	// ***********************************************************************************************************
	// Section de code : FieldLabels
	// ***********************************************************************************************************

	public static TextField createLinkField() {
		TextField res = new TextField(UserMessageConstants.LABEL_LINK);
		res.setPrefixComponent(VaadinIcon.LINK.create());
		return res;
	}

	public static TextField createDownloadLinkField() {
		TextField res = new TextField(UserMessageConstants.LABEL_DOWNLOAD_LINK);
		res.setPrefixComponent(VaadinIcon.DOWNLOAD.create());
		return res;
	}

	public static TextField createTypeField() {
		TextField res = new TextField(UserMessageConstants.LABEL_TYPE);
		return res;
	}

	public static TextField createIdolsField() {
		TextField res = new TextField(UserMessageConstants.LABEL_IDOLS);
		res.setPrefixComponent(VaadinIcon.USER_STAR.create());
		return res;
	}

	public static TextField createPersonNameField() {
		TextField res = new TextField(UserMessageConstants.LABEL_NAME);
		res.setPrefixComponent(VaadinIcon.USER.create());
		return res;
	}

	public static TextField createMovieNameField() {
		TextField res = new TextField(UserMessageConstants.LABEL_NAME);
		res.setPrefixComponent(VaadinIcon.MOVIE.create());
		return res;
	}

	public static TextField createMovieNameEnField() {
		TextField res = new TextField(UserMessageConstants.LABEL_NAME_EN);
		res.setPrefixComponent(VaadinIcon.MOVIE.create());
		return res;
	}

	public static TextField createMovieNameFrField() {
		TextField res = new TextField(UserMessageConstants.LABEL_NAME_FR);
		res.setPrefixComponent(VaadinIcon.MOVIE.create());
		return res;
	}

	public static DatePicker createReleaseDateField() {
		DatePicker res = new DatePicker(UserMessageConstants.LABEL_RELEASE_DATE);
		return res;
	}

	public static NumberField createRatingField() {
		NumberField res = new NumberField(UserMessageConstants.LABEL_RATING);
		res.setPrefixComponent(VaadinIcon.STAR_HALF_LEFT_O.create());
		return res;
	}

	public static IntegerField createEpisodeCountField() {
		IntegerField res = new IntegerField(UserMessageConstants.LABEL_EPISODE_COUNT);
		res.setPrefixComponent(VaadinIcon.PLAY.create());
		return res;
	}

	public static IntegerField createBookCountField() {
		IntegerField res = new IntegerField(UserMessageConstants.LABEL_BOOK_COUNT);
		res.setPrefixComponent(VaadinIcon.BOOK.create());
		return res;
	}

	public static Checkbox createWatchedField() {
		Checkbox res = new Checkbox(UserMessageConstants.LABEL_WATCHED);
		return res;
	}

	public static Checkbox createOwnedField() {
		Checkbox res = new Checkbox(UserMessageConstants.LABEL_OWNED);
		return res;
	}

	public static Checkbox createRunningField() {
		Checkbox res = new Checkbox(UserMessageConstants.LABEL_RUNNING);
		return res;
	}

	public static Checkbox createLikedField() {
		Checkbox res = new Checkbox(UserMessageConstants.LABEL_LIKED);
		return res;
	}

	public static ComboBox<PornstarStatus> createPornstarStatusField() {
		ComboBox<PornstarStatus> res = new ComboBox<Pornstar.PornstarStatus>(UserMessageConstants.LABEL_STATUS);
		res.setItems(Pornstar.PornstarStatus.values());
		return res;
	}

	public static ComboBox<PornstarEthnicity> createPornstarEthnicityField() {
		ComboBox<PornstarEthnicity> res = new ComboBox<Pornstar.PornstarEthnicity>(
				UserMessageConstants.LABEL_ETHNICITY);
		res.setItems(Pornstar.PornstarEthnicity.values());
		return res;
	}

}

package com.application.client.view.login;

import com.vaadin.flow.component.login.LoginI18n;
import com.vaadin.flow.component.login.LoginOverlay;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.Route;

@PageTitle("Login")
@Route(value = "login")
public class LoginView extends LoginOverlay {

	private static final long serialVersionUID = -5013918262571856975L;

	public LoginView() {
		this.setAction("login");

		LoginI18n i18n = LoginI18n.createDefault();
		i18n.setHeader(new LoginI18n.Header());
		i18n.getHeader().setTitle("medialib");
		i18n.getHeader().setDescription("Login using user/user or admin/admin");
		i18n.setAdditionalInformation(null);
		this.setI18n(i18n);

		this.setForgotPasswordButtonVisible(false);
		this.setOpened(true);
	}

}

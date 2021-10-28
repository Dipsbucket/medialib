package com.application.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.application.client.view.about.AboutView;
import com.application.client.view.helloworld.HelloWorldView;
import com.application.server.data.AuthenticatedUser;
import com.application.server.data.entity.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.applayout.DrawerToggle;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.button.ButtonVariant;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H1;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.Header;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

/**
 * The main view is a top-level placeholder for other views.
 */
@PageTitle("Main")
public class MainLayout extends AppLayout {

	public static class MenuItemInfo {

		private String text;
		private String iconClass;
		private Class<? extends Component> view;

		public MenuItemInfo(String text, String iconClass, Class<? extends Component> view) {
			this.text = text;
			this.iconClass = iconClass;
			this.view = view;
		}

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

	private H1 viewTitle;

	private AuthenticatedUser authenticatedUser;
	private AccessAnnotationChecker accessChecker;

	public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker) {
		this.authenticatedUser = authenticatedUser;
		this.accessChecker = accessChecker;

		this.setPrimarySection(Section.DRAWER);
		this.addToNavbar(true, this.createHeaderContent());
		this.addToDrawer(this.createDrawerContent());
	}

	private Component createHeaderContent() {
		DrawerToggle toggle = new DrawerToggle();
		toggle.addClassName("text-secondary");
		toggle.addThemeVariants(ButtonVariant.LUMO_CONTRAST);
		toggle.getElement().setAttribute("aria-label", "Menu toggle");

		this.viewTitle = new H1();
		this.viewTitle.addClassNames("m-0", "text-l");

		Header header = new Header(toggle, this.viewTitle);
		header.addClassNames("bg-base", "border-b", "border-contrast-10", "box-border", "flex", "h-xl", "items-center",
				"w-full");
		return header;
	}

	private Component createDrawerContent() {
		H2 appName = new H2("medialib");
		appName.addClassNames("flex", "items-center", "h-xl", "m-0", "px-m", "text-m");

		com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
				this.createNavigation(), this.createFooter());
		section.addClassNames("flex", "flex-col", "items-stretch", "max-h-full", "min-h-full");
		return section;
	}

	private Nav createNavigation() {
		Nav nav = new Nav();
		nav.addClassNames("border-b", "border-contrast-10", "flex-grow", "overflow-auto");
		nav.getElement().setAttribute("aria-labelledby", "views");

		H3 views = new H3("Views");
		views.addClassNames("flex", "h-m", "items-center", "mx-m", "my-0", "text-s", "text-tertiary");
		views.setId("views");

		// Wrap the links in a list; improves accessibility
		UnorderedList list = new UnorderedList();
		list.addClassNames("list-none", "m-0", "p-0");
		nav.add(list);

		for (RouterLink link : this.createLinks()) {
			ListItem item = new ListItem(link);
			list.add(item);
		}
		return nav;
	}

	private List<RouterLink> createLinks() {
		MenuItemInfo[] menuItems = new MenuItemInfo[] { //
				new MenuItemInfo("Hello World", "la la-th-list", HelloWorldView.class), //

				new MenuItemInfo("About", "la la-file", AboutView.class), //

		};
		List<RouterLink> links = new ArrayList<>();
		for (MenuItemInfo menuItemInfo : menuItems) {
			if (this.accessChecker.hasAccess(menuItemInfo.getView())) {
				links.add(createLink(menuItemInfo));
			}

		}
		return links;
	}

	private static RouterLink createLink(MenuItemInfo menuItemInfo) {
		RouterLink link = new RouterLink();
		link.addClassNames("flex", "mx-s", "p-s", "relative", "text-secondary");
		link.setRoute(menuItemInfo.getView());

		Span icon = new Span();
		icon.addClassNames("me-s", "text-l");
		if (!menuItemInfo.getIconClass().isEmpty()) {
			icon.addClassNames(menuItemInfo.getIconClass());
		}

		Span text = new Span(menuItemInfo.getText());
		text.addClassNames("font-medium", "text-s");

		link.add(icon, text);
		return link;
	}

	private Footer createFooter() {
		Footer layout = new Footer();
		layout.addClassNames("flex", "items-center", "my-s", "px-m", "py-xs");

		Optional<User> maybeUser = this.authenticatedUser.get();
		if (maybeUser.isPresent()) {
			User user = maybeUser.get();

			Avatar avatar = new Avatar(user.getName(), user.getImagePath());
			avatar.addClassNames("me-xs");

			ContextMenu userMenu = new ContextMenu(avatar);
			userMenu.setOpenOnClick(true);
			userMenu.addItem("Logout", e -> {
				this.authenticatedUser.logout();
			});

			Span name = new Span(user.getName());
			name.addClassNames("font-medium", "text-s", "text-secondary");

			layout.add(avatar, name);
		} else {
			Anchor loginLink = new Anchor("login", "Sign in");
			layout.add(loginLink);
		}

		return layout;
	}

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		this.viewTitle.setText(this.getCurrentPageTitle());
	}

	private String getCurrentPageTitle() {
		PageTitle title = this.getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}
}

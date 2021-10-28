package com.application.client.view;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import com.application.client.component.HeaderContainer;
import com.application.client.presenter.DocumentaryImageGridPresenter;
import com.application.client.presenter.HentaiImageGridPresenter;
import com.application.client.presenter.MovieImageGridPresenter;
import com.application.client.presenter.PornstarImageGridPresenter;
import com.application.client.presenter.SpectacleImageGridPresenter;
import com.application.client.view.about.AboutView;
import com.application.client.view.helloworld.HelloWorldView;
import com.application.server.data.AuthenticatedUser;
import com.application.server.data.entity.User;
import com.vaadin.flow.component.Component;
import com.vaadin.flow.component.applayout.AppLayout;
import com.vaadin.flow.component.avatar.Avatar;
import com.vaadin.flow.component.contextmenu.ContextMenu;
import com.vaadin.flow.component.html.Anchor;
import com.vaadin.flow.component.html.Footer;
import com.vaadin.flow.component.html.H2;
import com.vaadin.flow.component.html.H3;
import com.vaadin.flow.component.html.ListItem;
import com.vaadin.flow.component.html.Nav;
import com.vaadin.flow.component.html.Span;
import com.vaadin.flow.component.html.UnorderedList;
import com.vaadin.flow.router.PageTitle;
import com.vaadin.flow.router.RouterLink;
import com.vaadin.flow.server.auth.AccessAnnotationChecker;

import utils.CastUtils;

/**
 * The main view is a top-level placeholder for other views.
 */
@PageTitle("Main")
public class MainLayout extends AppLayout {

	// ***********************************************************************************************************
	// Section de code : Variables
	// ***********************************************************************************************************

	private static final long serialVersionUID = 2718947914251598560L;

	private final AuthenticatedUser authenticatedUser;
	private final AccessAnnotationChecker accessChecker;

	private PornstarImageGridPresenter pornstarImageGridPresenter;
	private MovieImageGridPresenter movieImageGridPresenter;
	private DocumentaryImageGridPresenter documentaryImageGridPresenter;
	private HentaiImageGridPresenter hentaiImageGridPresenter;
	private SpectacleImageGridPresenter spectacleImageGridPresenter;

	private HeaderContainer header;

	// ***********************************************************************************************************
	// Section de code : Constructeurs
	// ***********************************************************************************************************

	public MainLayout(AuthenticatedUser authenticatedUser, AccessAnnotationChecker accessChecker,
			@Autowired PornstarImageGridPresenter pornstarImageGridPresenter,
			@Autowired MovieImageGridPresenter movieImageGridPresenter,
			@Autowired DocumentaryImageGridPresenter documentaryImageGridPresenter,
			@Autowired HentaiImageGridPresenter hentaiImageGridPresenter,
			@Autowired SpectacleImageGridPresenter spectacleImageGridPresenter) {
		this.authenticatedUser = authenticatedUser;
		this.accessChecker = accessChecker;

		this.pornstarImageGridPresenter = pornstarImageGridPresenter;
		this.movieImageGridPresenter = movieImageGridPresenter;
		this.documentaryImageGridPresenter = documentaryImageGridPresenter;
		this.hentaiImageGridPresenter = hentaiImageGridPresenter;
		this.spectacleImageGridPresenter = spectacleImageGridPresenter;

		this.header = new HeaderContainer();

		this.setPrimarySection(Section.DRAWER);
		this.addToNavbar(true, this.header);
		this.addToDrawer(this.createDrawerContent());
	}

	// ***********************************************************************************************************
	// Section de code : Surcharges
	// ***********************************************************************************************************

	@Override
	protected void afterNavigation() {
		super.afterNavigation();
		this.header.getViewTitle().setText(this.getCurrentPageTitle());
		this.manageViewsAfterNavigation(this.getContent());
	}

	// ***********************************************************************************************************
	// Section de code : Méthodes
	// ***********************************************************************************************************

	private void manageViewsAfterNavigation(Component component) {
		if (component instanceof PornstarImageGridView) {
			final PornstarImageGridView view = CastUtils.uncheckedCast(component);
			this.pornstarImageGridPresenter.initView(view);
		} else if (component instanceof MovieImageGridView) {
			final MovieImageGridView view = CastUtils.uncheckedCast(component);
			this.movieImageGridPresenter.initView(view);
		} else if (component instanceof DocumentaryImageGridView) {
			final DocumentaryImageGridView view = CastUtils.uncheckedCast(component);
			this.documentaryImageGridPresenter.initView(view);
		} else if (component instanceof HentaiImageGridView) {
			final HentaiImageGridView view = CastUtils.uncheckedCast(component);
			this.hentaiImageGridPresenter.initView(view);
		} else if (component instanceof SpectacleImageGridView) {
			final SpectacleImageGridView view = CastUtils.uncheckedCast(component);
			this.spectacleImageGridPresenter.initView(view);
		}
	}

	private Component createDrawerContent() {
		final H2 appName = new H2("My App");
		appName.addClassNames("flex", "items-center", "h-xl", "m-0", "px-m", "text-m");

		final com.vaadin.flow.component.html.Section section = new com.vaadin.flow.component.html.Section(appName,
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
				new MenuItemInfo("Movies", "la la-th-list", MovieImageGridView.class),
				new MenuItemInfo("Documentaries", "la la-th-list", DocumentaryImageGridView.class),
				new MenuItemInfo("Spectacles", "la la-th-list", SpectacleImageGridView.class),
				new MenuItemInfo("Pornstars", "la la-th-list", PornstarImageGridView.class),
				new MenuItemInfo("Hentais", "la la-th-list", HentaiImageGridView.class),
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

	private String getCurrentPageTitle() {
		PageTitle title = this.getContent().getClass().getAnnotation(PageTitle.class);
		return title == null ? "" : title.value();
	}
}

package com.ioon.ihtsclean.web.client;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceChangeEvent;
import com.google.web.bindery.event.shared.EventBus;
import com.ioon.ihtsclean.web.client.place.AppLoginPlace;
import com.ioon.ihtsclean.web.client.ui.AppLayout;
import com.ioon.ihtsclean.web.client.ui.mainMenu.MainMenuView;
import com.ioon.ihtsclean.web.client.ui.mainMenu.MainMenuViewImpl;

public class AppController implements MainMenuView.Presenter {

	private final ClientFactory clientFactory;

	public AppController(final AppLayout appLayout, ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
		MainMenuViewImpl mainMenuView = clientFactory.getMainMenuView();
		mainMenuView.setPresenter(this);
		EventBus eventBus = clientFactory.getEventBus();
		eventBus.addHandler(PlaceChangeEvent.TYPE, new HandlePlaceLayout(
				appLayout));
	}

	public void goTo(Place place) {
		clientFactory.goTo(place);
	}

	@Override
	public void logout() {
		clientFactory.logoutUser();
	}

	private static class HandlePlaceLayout implements PlaceChangeEvent.Handler {
		private final AppLayout appLayout;

		public HandlePlaceLayout(AppLayout appLayout) {
			this.appLayout = appLayout;
		}

		@Override
		public void onPlaceChange(PlaceChangeEvent event) {
			Place newPlace = event.getNewPlace();

			if (newPlace instanceof AppLoginPlace) {
				appLayout.setLayout();
			}
		}
	}
}

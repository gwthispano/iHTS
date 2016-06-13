package com.ioon.ihtsclean.web.client;

import com.allen_sauer.gwt.log.client.Log;
import com.google.web.bindery.event.shared.EventBus;
import com.google.web.bindery.event.shared.SimpleEventBus;
import com.ioon.ihtsclean.web.backend.AppRequest;
import com.ioon.ihtsclean.web.backend.AppRequestImpl;
import com.ioon.ihtsclean.web.client.ClientFactoryImpl;
import com.ioon.ihtsclean.web.client.place.AppHomePlace;
import com.ioon.ihtsclean.web.client.place.AppLoginPlace;
import com.ioon.ihtsclean.web.client.ui.appLogin.AppLoginViewImpl;
import com.ioon.ihtsclean.web.client.ui.homeView.AppHomeViewImpl;
import com.ioon.ihtsclean.web.client.ui.mainMenu.MainMenuViewImpl;
import com.ioon.ihtscommon.web.client.model.User;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.ScrollPanel;

public class ClientFactoryImpl implements ClientFactory {

	private static final EventBus eventBus = new SimpleEventBus();
	private static final PlaceController placeController = new PlaceController(
			eventBus);

	private static ScrollPanel mainPanel;
	private static MainMenuViewImpl mainMenuView;
	private static AppLoginViewImpl appLoginView;
	private static AppHomeViewImpl appHomeView;
	
	private static boolean isLogged = false;
	private static User user = null;
	
	private void initViews() {
	}

	@Override
	public void setMainPanel(ScrollPanel scrollPanel) {
		mainPanel = scrollPanel;
	}

	@Override
	public void logUser(User user) {
		isLogged = true;
		showMenu();
		initViews();
		
		ClientFactoryImpl.user = user;
		//mainMenuView.setUser(user);
	}

	@Override
	public void logoutUser() {
		//LogoutRequest request = new LogoutRequest(mainMenuView.getUser());
		//request.send();
	}

	@Override
	public boolean isLogged() {
		return isLogged;
	}

	@Override
	public User getUser() {
		return user;
	}

	@Override
	public void showMenu() {
		mainMenuView.showMenu();
	}

	@Override
	public void hideMenu() {
		mainMenuView.hideMenu();
	}
	
	@Override
	public void visibleMenu(boolean visible) {
		mainMenuView.setVisible(visible);
	}
		
	@Override
	public void goTo(Place newPlace) {
		//mainMenuView.hidePushButton();
		
		if (isLogged()) {

			if (newPlace instanceof AppHomePlace) {
				//mainMenuView.initPath("");
				
			}

			placeController.goTo(newPlace);
		} else {
			placeController.goTo(new AppLoginPlace());
		}
	}

	@Override
	public EventBus getEventBus() {
		return eventBus;
	}

	@Override
	public PlaceController getPlaceController() {
		return placeController;
	}

	@Override
	public MainMenuViewImpl getMainMenuView() {
		if (mainMenuView == null) {
			mainMenuView = new MainMenuViewImpl();
		}

		return mainMenuView;
	}

	@Override
	public AppLoginViewImpl getAppLoginView() {
		if (appLoginView == null) {
			appLoginView = new AppLoginViewImpl();
		}

		return appLoginView;
	}

	@Override
	public AppHomeViewImpl getAppHomeView() {
		if (appHomeView == null) {
			appHomeView = new AppHomeViewImpl();
		}

		return appHomeView;
	}
	
	public class LogoutRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		private String user;

		public LogoutRequest(String user) {
			this.user = user;
			request = new AppRequestImpl();
			request.setListener(this);
		}

		// Asincronous
		/*public void send() {
			request.post(WebServiceData.logoutUrlPOST(),
					WebServiceData.logoutJsonParamsPOST(user),
					WebServiceData.getContentTypeJson());
		}*/

		@Override
		public void requestOk(String textRequest) {
			ClientFactoryImpl.isLogged = false;
			user = null;
			//mainMenuView.setUser(null);
			goTo(new AppLoginPlace());
		}

		@Override
		public void requestException(Throwable exception) {
			ClientFactoryImpl.isLogged = false;
			//mainMenuView.setUser(null);
			goTo(new AppLoginPlace());

			Log.warn("Ignore exception at logout request", exception);
		}
	}
}

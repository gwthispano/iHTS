package com.ioon.ihtsclean.web.client;

import com.google.web.bindery.event.shared.EventBus;
import com.ioon.ihtsclean.web.client.ui.appLogin.AppLoginViewImpl;
import com.ioon.ihtsclean.web.client.ui.homeView.AppHomeViewImpl;
import com.ioon.ihtsclean.web.client.ui.mainMenu.MainMenuViewImpl;
import com.ioon.ihtscommon.web.client.model.User;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.user.client.ui.ScrollPanel;

public interface ClientFactory {
	
	void setMainPanel(ScrollPanel mainPanel);
	
	void logUser(User user);
	
	void logoutUser();
	
	boolean isLogged();
	
	User getUser();
	
	void showMenu();
	
	void hideMenu();
	
	void visibleMenu(boolean enabled);
	
	void goTo(Place newPlace);

	EventBus getEventBus();

	PlaceController getPlaceController();

	MainMenuViewImpl getMainMenuView();

	AppLoginViewImpl getAppLoginView();
	
	AppHomeViewImpl getAppHomeView();	
}

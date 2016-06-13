package com.ioon.ihtsclean.web.client.ui.mainMenu;

import com.google.gwt.place.shared.Place;
import com.google.gwt.user.client.ui.IsWidget;

public interface MainMenuView extends IsWidget {

	//void setUser(User user);
	void showMenu();
	void hideMenu();
	//String getUser();

	void setPresenter(Presenter presenter);
	void setPresenterPushButton(PresenterPushButton presenter);

	public interface Presenter {

		void goTo(Place newPlace);
		void logout();
	}
	
	public interface PresenterPushButton {
		public enum TypeButton {RETURN, VALIDATE, REJECT, ALBARAN, ALBARAN_SIN_EUROWIN, SAVE, PRINT, CANCEL, NEW, DELETE};
		
		void onClick(TypeButton type);
	}
}

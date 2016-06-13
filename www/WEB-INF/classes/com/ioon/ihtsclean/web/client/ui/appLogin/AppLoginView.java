package com.ioon.ihtsclean.web.client.ui.appLogin;

import com.google.gwt.user.client.ui.IsWidget;
import com.ioon.ihtsclean.web.client.ui.component.appUserMessages.AppUserMessages;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its
 * container widget.
 */
public interface AppLoginView extends IsWidget, AppUserMessages {

	void clean();
	
	void cleanData();
	
	void setFocus();
	
	void setPresenter(Presenter listener);

	public interface Presenter {
		void logUser(String user, String password);
	}
}
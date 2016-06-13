package com.ioon.ihtsclean.web.client.ui.component.appUserMessages;

import com.google.gwt.user.client.ui.IsWidget;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its
 * container widget.
 */
public interface AppUserMessages extends IsWidget {
	
	void confirmationMessage(String message, final CallBackConfirmationInterface callBack);
	void setMessage(String message);
	void setMessage(Throwable exception);
	void showLoadingDialog();
	void hideLoadingDialog();
	
	public interface CallBackConfirmationInterface {
		public void confirm(boolean result);
	}
}
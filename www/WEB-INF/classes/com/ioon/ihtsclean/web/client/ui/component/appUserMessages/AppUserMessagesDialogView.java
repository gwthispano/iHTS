package com.ioon.ihtsclean.web.client.ui.component.appUserMessages;

import com.allen_sauer.gwt.log.client.Log;
import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Button;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.Widget;
import com.ioon.ihtsclean.web.client.i18n.userMessages.AppMessages;
import com.ioon.ihtscommon.web.client.AppException;

public class AppUserMessagesDialogView extends DialogBox  {

	private static JabarLoadingDialogViewUiBinder uiBinder = GWT
			.create(JabarLoadingDialogViewUiBinder.class);

	interface JabarLoadingDialogViewUiBinder extends
			UiBinder<Widget, AppUserMessagesDialogView> {
	}
	
	private AppMessages messages = GWT.create(AppMessages.class);

	@UiField
	Label messageLabel;
	
	@UiField
	Button acceptButton;

	public AppUserMessagesDialogView() {
		setWidget(uiBinder.createAndBindUi(this));
		setText("");
	}
	
	public void showMessage(String message) {
		this.center();
		
		Log.info("USER MESSAGE: "+message);
		messageLabel.setText(message);
		
		acceptButton.setFocus(true);
	}
	
	public void showMessage(Throwable exception) {	   
		this.center();
		
		if (exception instanceof AppException) {
			messageLabel.setText(exception.getMessage());
			Log.fatal("APP EXCEPTION\nstatus: "+((AppException)exception).getStatusCode()+" - "+((AppException)exception).getStatusText()+"\n"+((AppException)exception).getResponseText(), exception);
		} else {
			messageLabel.setText(messages.generalError());
			Log.fatal("EXCEPTION", exception);
		}
		
		acceptButton.setFocus(true);
	}
	
	// HANDLER'S
	@UiHandler("acceptButton")
	void onClickAcceptButton(ClickEvent e) {
		this.hide();
	}
}

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
import com.ioon.ihtsclean.web.client.ui.component.appUserMessages.AppUserMessages.CallBackConfirmationInterface;

public class AppUserMessagesConfirmationDialogView extends DialogBox  {

	private static JabarLoadingDialogViewUiBinder uiBinder = GWT
			.create(JabarLoadingDialogViewUiBinder.class);

	interface JabarLoadingDialogViewUiBinder extends
			UiBinder<Widget, AppUserMessagesConfirmationDialogView> {
	}
	
	private CallBackConfirmationInterface callBack;

	@UiField
	Label messageLabel;
	
	@UiField
	Button yesButton;
	@UiField
	Button noButton;

	public AppUserMessagesConfirmationDialogView() {
		setWidget(uiBinder.createAndBindUi(this));
		setText("");
	}
	
	public void showMessage(String message, final CallBackConfirmationInterface callBack) {
		this.callBack = callBack;
		this.center();
		
		Log.info("USER MESSAGE: "+message);
		messageLabel.setText(message);
		
		noButton.setFocus(true);
	}
	
	// HANDLER'S
	@UiHandler("yesButton")
	void onClickYesButton(ClickEvent e) {
		callBack.confirm(true);
		this.hide();
	}
	
	@UiHandler("noButton")
	void onClickNoButton(ClickEvent e) {
		callBack.confirm(false);
		this.hide();
	}
}

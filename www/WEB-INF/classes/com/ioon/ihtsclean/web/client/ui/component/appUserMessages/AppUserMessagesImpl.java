package com.ioon.ihtsclean.web.client.ui.component.appUserMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AppUserMessagesImpl extends Composite implements
		AppUserMessages {

	private static JabarUserMessagesImplUiBinder uiBinder = GWT
			.create(JabarUserMessagesImplUiBinder.class);

	interface JabarUserMessagesImplUiBinder extends
			UiBinder<Widget, AppUserMessagesImpl> {
	}
	
	private AppLoadingDialogView loadingDialogBox = new AppLoadingDialogView();
	private AppUserMessagesDialogView userMessagesDialogBox = new AppUserMessagesDialogView();
	private AppUserMessagesConfirmationDialogView userMessagesConfirmationDialogBox = new AppUserMessagesConfirmationDialogView();

	public AppUserMessagesImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}
	
	@Override
	public void confirmationMessage(String message, final CallBackConfirmationInterface callBack) {
		hideLoadingDialog();
		userMessagesConfirmationDialogBox.showMessage(message, callBack);
	}

	@Override
	public void setMessage(String message) {
		hideLoadingDialog();
		userMessagesDialogBox.showMessage(message);
	}

	@Override
	public void setMessage(Throwable exception) {
		hideLoadingDialog();
		userMessagesDialogBox.showMessage(exception);
	}

	@Override
	public void showLoadingDialog() {
		//It's like a show center
		loadingDialogBox.center();
	}

	@Override
	public void hideLoadingDialog() {
		loadingDialogBox.hide();
	}
}

package com.ioon.ihtsclean.web.client.ui.appLogin;

import org.gwtbootstrap3.client.ui.Button;
import org.gwtbootstrap3.client.ui.Input;
import org.gwtbootstrap3.client.ui.TextBox;

import com.google.gwt.core.client.GWT;
import com.google.gwt.event.dom.client.ClickEvent;
import com.google.gwt.event.dom.client.KeyCodes;
import com.google.gwt.event.dom.client.KeyPressEvent;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.uibinder.client.UiHandler;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ioon.ihtsclean.web.client.ui.component.appUserMessages.AppUserMessages;

public class AppLoginViewImpl extends Composite implements AppLoginView {

	private static JabarHomeViewImplUiBinder uiBinder = GWT
			.create(JabarHomeViewImplUiBinder.class);

	interface JabarHomeViewImplUiBinder extends
			UiBinder<Widget, AppLoginViewImpl> {
	}
	
	private Presenter presenter;

	@UiField
	TextBox user;
	@UiField
	Input password;
	@UiField
	Button acceptButtom;
	@UiField
	AppUserMessages userMessages;

	public AppLoginViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

	/***************************
	 * START VIEW METHOD
	 ***************************/
	
	@Override
	public void setPresenter(Presenter listener) {
		this.presenter = listener;
	}
	
	@Override
	public void clean() {
		cleanData();
	}
	
	@Override
	public void setFocus() {
		user.setFocus(true);
	}
	
	@Override
	public void cleanData() {
		user.setText("");
		password.setText("");
	}
	
	/***************************
	 * END VIEW METHOD
	 ***************************/
	
	/***************************
	 * START PRIVATE VIEW METHOD
	 ***************************/
	
	private void logUser(String user, String password) {
		presenter.logUser(user.trim(), password.trim());
	}
	
	/***************************
	 * END PRIVATE VIEW METHOD
	 ***************************/
	
	/***************************
	 * START VIEW EVENT HANDLER
	 ***************************/
	
	@UiHandler("user")
	void onPressKeyUser(KeyPressEvent event) {
	    if (event.getCharCode() == KeyCodes.KEY_ENTER)
	    {
	    	password.setFocus(true);
	    }
	}
	
	@UiHandler("password")
	void onPressKeyPassword(KeyPressEvent event) {
	    if (event.getCharCode() == KeyCodes.KEY_ENTER)
	    {
	    	logUser(user.getText(), password.getText());
	    }
	}

	@UiHandler("acceptButtom")
	void onClick(ClickEvent event) {
		logUser(user.getText(), password.getText());
	}
	
	/***************************
	 * END VIEW EVENT HANDLER
	 ***************************/

	/*****************************
	 * START AppUserMessages METHOD
	 *****************************/

	@Override
	public void setMessage(String message) {
		userMessages.setMessage(message);
	}

	@Override
	public void setMessage(Throwable exception) {
		userMessages.setMessage(exception);
	}
	
	@Override
	public void showLoadingDialog() {
		userMessages.showLoadingDialog();
	}

	@Override
	public void hideLoadingDialog() {
		userMessages.hideLoadingDialog();
	}

	@Override
	public void confirmationMessage(String message, CallBackConfirmationInterface callBack) {
		userMessages.confirmationMessage(message, callBack);
	}
	
	/*****************************
	 * END AppUserMessages METHOD
	 *****************************/
}

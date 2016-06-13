package com.ioon.ihtsclean.web.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.core.shared.GWT;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.ioon.ihtsclean.web.backend.AppRequest;
import com.ioon.ihtsclean.web.backend.AppRequestImpl;
import com.ioon.ihtsclean.web.backend.WebServiceData;
import com.ioon.ihtsclean.web.client.ClientFactory;
import com.ioon.ihtsclean.web.client.i18n.userMessages.AppMessages;
import com.ioon.ihtsclean.web.client.place.AppHomePlace;
import com.ioon.ihtsclean.web.client.ui.appLogin.AppLoginView;
import com.ioon.ihtsclean.web.client.utils.Utils;
import com.ioon.ihtscommon.web.client.backend.login.LoginResponse;
import com.ioon.ihtscommon.web.client.model.User;

public class AppLoginActivity extends AbstractActivity implements
		AppLoginView.Presenter {

	private AppMessages messages = GWT.create(AppMessages.class);
	private ClientFactory clientFactory;
	private AppLoginView view;

	public AppLoginActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		clientFactory.hideMenu();
		view = clientFactory.getAppLoginView();
		view.setPresenter(this);
		view.clean();
		containerWidget.setWidget(view.asWidget());  //Show the view to the window
		view.setFocus();
	}

	/***************************
	 * START PRESENTER METHODS
	 ***************************/
	
	public void logUser(final String user, String password) {
		if (!Utils.isEmpty(user) && !Utils.isEmpty(password)) {
			LoginRequest request = new LoginRequest(user, password);
			request.send();

		} else {
			view.setMessage(messages.invalidDataLogin());
			view.setFocus();
		}
	}
	
	/***************************
	 * END PRESENTER METHODS
	 ***************************/
	
	/***************************
	 * START ACTIVITY CLASSES
	 ***************************/
	
	public class LoginRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		private String user;
		private String password;
		
		public LoginRequest(String user, String password) {
			this.user = user;
			this.password = password;
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send() {
			view.showLoadingDialog();
			
			request.postLogin(WebServiceData.loginUrlPOST(), WebServiceData.getContentTypeJson(), user, password);
		}

		@Override
		public void requestOk(String textResponse) {
			view.hideLoadingDialog();
			
			LoginResponse dataResponse = LoginResponse.asLoginResponse(textResponse);
			User userLogin = new User(user, password, dataResponse.getToken());
			
			clientFactory.logUser(userLogin);
			
			clientFactory.goTo(new AppHomePlace());
		}

		@Override
		public void requestException(Throwable exception) {
			view.setMessage(exception);
			view.setFocus();
		}
	}
	
	/***************************
	 * END ACTIVITY CLASSES
	 ***************************/
}

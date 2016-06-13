package com.ioon.ihtsclean.web.client.activity;

import com.google.gwt.activity.shared.AbstractActivity;
import com.google.gwt.event.shared.EventBus;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.ioon.ihtsclean.web.client.ClientFactory;
import com.ioon.ihtsclean.web.client.ui.homeView.AppHomeView;

public class AppHomeActivity extends AbstractActivity {

	private ClientFactory clientFactory;

	public AppHomeActivity(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	/**
	 * Invoked by the ActivityManager to start a new Activity
	 */
	@Override
	public void start(AcceptsOneWidget containerWidget, EventBus eventBus) {
		clientFactory.showMenu();
		AppHomeView view = clientFactory.getAppHomeView();
		containerWidget.setWidget(view.asWidget());
	}
}

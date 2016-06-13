package com.ioon.ihtsclean.web.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.ioon.ihtsclean.web.client.ClientFactory;
import com.ioon.ihtsclean.web.client.activity.AppHomeActivity;
import com.ioon.ihtsclean.web.client.activity.AppLoginActivity;
import com.ioon.ihtsclean.web.client.place.AppHomePlace;
import com.ioon.ihtsclean.web.client.place.AppLoginPlace;

public class MainPanelContentActivityMapper implements ActivityMapper {

	private ClientFactory clientFactory;

	public MainPanelContentActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {
		Activity activity = null;

		if (place instanceof AppLoginPlace) {
			activity = new AppLoginActivity(clientFactory);

		} else if (place instanceof AppHomePlace) {
			activity = new AppHomeActivity(clientFactory);	

		}
		
		return activity;
	}
}

package com.ioon.ihtsclean.web.client.mvp;

import com.google.gwt.activity.shared.Activity;
import com.google.gwt.activity.shared.ActivityMapper;
import com.google.gwt.place.shared.Place;
import com.ioon.ihtsclean.web.client.ClientFactory;

public class RightPanelContentActivityMapper implements ActivityMapper {
	
	private ClientFactory clientFactory;

	public RightPanelContentActivityMapper(ClientFactory clientFactory) {
		this.clientFactory = clientFactory;
	}

	public Activity getActivity(Place place) {

		return null;
	}
}

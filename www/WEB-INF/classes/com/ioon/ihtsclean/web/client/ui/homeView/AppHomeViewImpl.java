package com.ioon.ihtsclean.web.client.ui.homeView;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;

public class AppHomeViewImpl extends Composite  implements AppHomeView {

	private static DefaultViewImplUiBinder uiBinder = GWT
			.create(DefaultViewImplUiBinder.class);

	interface DefaultViewImplUiBinder extends UiBinder<Widget, AppHomeViewImpl> {
	}

	public AppHomeViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
	}

}

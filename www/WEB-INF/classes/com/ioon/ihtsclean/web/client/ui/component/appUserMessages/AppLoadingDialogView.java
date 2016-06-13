package com.ioon.ihtsclean.web.client.ui.component.appUserMessages;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.user.client.ui.DialogBox;
import com.google.gwt.user.client.ui.Widget;

public class AppLoadingDialogView extends DialogBox  {

	private static JabarLoadingDialogViewUiBinder uiBinder = GWT
			.create(JabarLoadingDialogViewUiBinder.class);

	interface JabarLoadingDialogViewUiBinder extends
			UiBinder<Widget, AppLoadingDialogView> {
	}

	public AppLoadingDialogView() {
		setWidget(uiBinder.createAndBindUi(this));
		//setGlassEnabled(true);
		//setAnimationEnabled(true);
		setText("");
	}

}

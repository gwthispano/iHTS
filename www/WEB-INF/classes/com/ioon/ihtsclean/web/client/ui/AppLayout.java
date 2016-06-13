package com.ioon.ihtsclean.web.client.ui;

import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;

public interface AppLayout {

	FlowPanel getMainLayoutPanel();

	AcceptsOneWidget getMainPanelContainer();
	
	AcceptsOneWidget getRightPanelContainer();
	
	void setLayout();

}

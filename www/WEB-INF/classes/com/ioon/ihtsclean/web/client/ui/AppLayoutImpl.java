package com.ioon.ihtsclean.web.client.ui;


import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.AcceptsOneWidget;
import com.google.gwt.user.client.ui.FlowPanel;
import com.google.gwt.user.client.ui.IsWidget;
import com.google.gwt.user.client.ui.LayoutPanel;
import com.google.gwt.user.client.ui.ScrollPanel;
import com.google.gwt.user.client.ui.Widget;
import com.ioon.ihtsclean.web.client.ClientFactory;
import com.ioon.ihtsclean.web.client.ui.AppLayout;
import com.ioon.ihtsclean.web.client.ui.mainMenu.MainMenuViewImpl;
import static com.google.gwt.dom.client.Style.Unit.PCT;

public class AppLayoutImpl implements AppLayout {

	// % values
	private static final int MAINMENU_HEIGHT = 10;

	private final FlowPanel mainLayoutPanel;

	interface AppLayoutImplUiBinder extends
			UiBinder<FlowPanel, AppLayoutImpl> {
	}

	private static AppLayoutImplUiBinder uiBinder = GWT.create(AppLayoutImplUiBinder.class);

	//@UiField
	//SimplePanel menuPanel;
	@UiField
	ScrollPanel mainPanel;
	//@UiField
	//SimplePanel rightPanel;
	
	@UiField
	LayoutPanel centerPanel;

	@UiField(provided = true)
	MainMenuViewImpl mainMenu;


	public AppLayoutImpl(ClientFactory clientFactory) {
		mainMenu = clientFactory.getMainMenuView();
		mainLayoutPanel = uiBinder.createAndBindUi(this);
	}

	@Override
	public FlowPanel getMainLayoutPanel() {
		return mainLayoutPanel;
	}

	@Override
	public AcceptsOneWidget getMainPanelContainer() {
		return new AcceptsOneWidget() {
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				mainPanel.setWidget(widget);
				
			}
		};
	}
	
	@Override
	public AcceptsOneWidget getRightPanelContainer() {
		return new AcceptsOneWidget() {
			@Override
			public void setWidget(IsWidget w) {
				Widget widget = Widget.asWidgetOrNull(w);
				//rightPanel.setWidget(widget);
			}
		};
	}
	
	public void setLayout() {
		/*mainLayoutPanel.setWidgetTopHeight(menuPanel, 0, PCT, MAINMENU_HEIGHT,
				PCT);
		mainLayoutPanel.setWidgetLeftWidth(menuPanel, 0, PCT, 100, PCT);*/
		centerPanel.setWidgetTopHeight(mainPanel, MAINMENU_HEIGHT, PCT,
				100 - MAINMENU_HEIGHT, PCT);
		/*mainLayoutPanel.setWidgetLeftWidth(mainPanel, 0, PCT, 100, PCT);
		mainLayoutPanel.setWidgetRightWidth(rightPanel, 0, PCT, 0, PCT);
		mainLayoutPanel.animate(500);*/
	}
}

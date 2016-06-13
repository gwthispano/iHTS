package com.ioon.ihtsclean.web.client.ui.mainMenu;

import org.gwtbootstrap3.client.ui.Badge;
import org.gwtbootstrap3.client.ui.Navbar;
import org.gwtbootstrap3.client.ui.NavbarLink;

import com.google.gwt.core.client.GWT;
import com.google.gwt.uibinder.client.UiBinder;
import com.google.gwt.uibinder.client.UiField;
import com.google.gwt.user.client.ui.Composite;
import com.google.gwt.user.client.ui.Widget;
import com.ioon.ihtsclean.web.client.AppConstants;
import com.ioon.ihtsclean.web.client.i18n.userMessages.AppMessages;
import com.ioon.ihtsclean.web.client.ui.component.appUserMessages.AppUserMessages;

public class MainMenuViewImpl extends Composite implements MainMenuView {

	interface MainMenuViewUiBinder extends UiBinder<Widget, MainMenuViewImpl> {
	}

	private static MainMenuViewUiBinder uiBinder = GWT.create(MainMenuViewUiBinder.class);
	
	private AppConstants constants = GWT.create(AppConstants.class);
	private AppMessages messages = GWT.create(AppMessages.class);
	
	private Presenter presenter;
	private PresenterPushButton presenterPushButton;

	
	/*@UiField
	Label pathLabel;
	@UiField
	Label userLabel;
	@UiField
	Label salirLink;*/
	
	@UiField
	Navbar navBar;

	@UiField
	AppUserMessages userMessages;
	
	@UiField
	NavbarLink exit;
	
	@UiField
	NavbarLink collapseExit;
	
	@UiField
	NavbarLink alert;
	
	@UiField
	NavbarLink collapseAlert;
	
	//@UiField
	//NavbarBrand brand;

	public MainMenuViewImpl() {
		initWidget(uiBinder.createAndBindUi(this));
		
		Badge num = new Badge("4");
		Badge num2 = new Badge("4");
		
		alert.add(num2);
		alert.setColor("#FFFF00");
		collapseAlert.add(num);
		collapseAlert.setColor("#FFFF00");
		
		//Image img = new Image(Resources.INSTANCE.brandImage());
		//brand.add(img);
	}

	
	@Override
	public void showMenu() {
		navBar.setVisible(true);

	}

	@Override
	public void hideMenu() {
		navBar.setVisible(false);

	}
	

	
	@Override
	public void setVisible(boolean visible) {
		navBar.setVisible(visible);
	}
	
	

	@Override
	public void setPresenter(Presenter presenter) {
		this.presenter = presenter;
	}
	

	@Override
	public void setPresenterPushButton(PresenterPushButton presenter) {
		this.presenterPushButton = presenter;
	}
	
	// PRIVATE METHOD'S
	/*
	private void setMenuAccordingToRole(User user) {
		// ROLE
		if (user.getWorkerRole().equalsIgnoreCase(constants.roleTecnico())) {
			adminMenuItem.setVisible(false);
			
		} else {
			adminMenuItem.setVisible(true);
		}
	}
	*/
	
	// HANDLER'S
	/*@UiHandler("salirLink")
	void onClickSalirLink(ClickEvent e) {
		userMessages.confirmationMessage(messages.confirmationLogout(), new CallBackConfirmationInterface() {     
			@Override
			public void confirm(boolean result) {
				if (result) {
					presenter.logout();
				}	                      
			}
		});
	}
	
	@UiHandler("returnPushButton")
	void onClickReturnPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.RETURN);
	}
	
	@UiHandler("validatePushButton")
	void onClickValidatePushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.VALIDATE);
	}
	
	@UiHandler("rejectPushButton")
	void onClickRejetPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.REJECT);
	}
	
	@UiHandler("albaranPushButton")
	void onClickAlbaranPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.ALBARAN);
	}
	
	@UiHandler("albaranSinEurowinPushButton")
	void onClickAlbaranSinEurowinPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.ALBARAN_SIN_EUROWIN);
	}
	
	@UiHandler("savePushButton")
	void onClickSavePushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.SAVE);
	}
	
	@UiHandler("printPushButton")
	void onClickPrintPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.PRINT);
	}
	
	@UiHandler("cancelPushButton")
	void onClickCancelPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.CANCEL);
	}
	
	@UiHandler("newPushButton")
	void onClickNewPushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.NEW);
	}
	
	@UiHandler("deletePushButton")
	void onClickDeletePushButton(ClickEvent e) {
		presenterPushButton.onClick(MainMenuView.PresenterPushButton.TypeButton.DELETE);
	}*/

}

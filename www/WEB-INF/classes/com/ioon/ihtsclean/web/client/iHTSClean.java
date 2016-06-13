package com.ioon.ihtsclean.web.client;

import com.google.gwt.activity.shared.ActivityManager;
import com.google.gwt.core.client.EntryPoint;
import com.google.gwt.core.client.GWT;
import com.google.web.bindery.event.shared.EventBus;
import com.googlecode.gwtphonegap.client.PhoneGap;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableEvent;
import com.googlecode.gwtphonegap.client.PhoneGapAvailableHandler;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutEvent;
import com.googlecode.gwtphonegap.client.PhoneGapTimeoutHandler;
import com.googlecode.gwtphonegap.client.device.Device;
import com.ioon.ihtsclean.web.client.mvp.AppPlaceHistoryMapper;
import com.ioon.ihtsclean.web.client.mvp.MainPanelContentActivityMapper;
import com.ioon.ihtsclean.web.client.mvp.RightPanelContentActivityMapper;
import com.ioon.ihtsclean.web.client.place.AppLoginPlace;
import com.ioon.ihtsclean.web.client.ui.AppLayout;
import com.ioon.ihtsclean.web.client.ui.AppLayoutImpl;
import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceController;
import com.google.gwt.place.shared.PlaceHistoryHandler;
import com.google.gwt.user.client.Timer;
import com.google.gwt.user.client.Window;
import com.google.gwt.user.client.ui.Label;
import com.google.gwt.user.client.ui.RootLayoutPanel;
import com.google.gwt.user.client.ui.RootPanel;
import com.allen_sauer.gwt.log.client.Log;

public class iHTSClean implements EntryPoint {

    private PhoneGap phoneGap;
    private boolean isPhoneGap;
    
	private Place defaultPlace = new AppLoginPlace();
	
	private void start() 
	{
	    /*
	     * No guards necessary. Code will be compiled out when <code>log_level=OFF</code>
	     */
	    Log.debug("Start app");
	    
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();

		AppLayout appLayout = new AppLayoutImpl(clientFactory);

		// Main Panel Content container Activity Mapper
		MainPanelContentActivityMapper mainPanelActivityMapper = new MainPanelContentActivityMapper(clientFactory);
		ActivityManager mainPanelActivityManager = new ActivityManager(mainPanelActivityMapper, eventBus);
		mainPanelActivityManager.setDisplay(appLayout.getMainPanelContainer());

		// Right Panel Content container Activity Mapper
		RightPanelContentActivityMapper rightPanelActivityMapper = new RightPanelContentActivityMapper(clientFactory);
		ActivityManager rightPanelActivityManager = new ActivityManager(rightPanelActivityMapper, eventBus);
		rightPanelActivityManager.setDisplay(appLayout.getRightPanelContainer());

		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

		PlaceController placeController = clientFactory.getPlaceController();
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(appLayout.getMainLayoutPanel());
		new AppController(appLayout, clientFactory);

		historyHandler.handleCurrentHistory();
	                    
	    phoneGap = GWT.create(PhoneGap.class);
	    isPhoneGap = phoneGap.isPhoneGapDevice();
	            
	    if (isPhoneGap) 
	    {
	    	phoneGap.addHandler(new PhoneGapAvailableHandler() 
	    		{
	    			@Override
	    			public void onPhoneGapAvailable(PhoneGapAvailableEvent event) 
	    			{
	    				//start your app - phonegap is ready
	    				Device dev= phoneGap.getDevice();
	    				if (dev != null)
	    				{
	    					//RootPanel.get().add(new Label(phoneGap.getDevice().getVersion()));//version of the underlying OS
	    					//RootPanel.get().add(new Label(phoneGap.getDevice().getName())); // name of the device
	    					//RootPanel.get().add(new Label(phoneGap.getDevice().getPhoneGapVersion())); //phonegap version
	    					//RootPanel.get().add(new Label(phoneGap.getDevice().getPlatform())); // Android, Blackberry, iPhone, Browser...
	    					//RootPanel.get().add(new Label(phoneGap.getDevice().getUuid())); // a unique id identifiying the device                
	    				}
	    				else
	    				{
	    					RootPanel.get().add(new Label("Device object is NULL inside phonegap, should not happen"));
	    				}
	    			}
	    		});
	    	
	    	phoneGap.addHandler(new PhoneGapTimeoutHandler() 
	    		{
	    			@Override
	    			public void onPhoneGapTimeout(PhoneGapTimeoutEvent event) {
	    				//can not start phonegap - something is for with your setup
	    				RootPanel.get().add(new Label("PhoneGap startup timeout"));
	    			}
	    		});

	    	phoneGap.initializePhoneGap();                
	    }
	    else
	    {
	    	//RootPanel.get().add(new Label("Not running inside phonegap"));
	    }
	}

	public void start2() {
	    /*
	     * No guards necessary. Code will be compiled out when <code>log_level=OFF</code>
	     */
	    Log.debug("Start app");
	    
		ClientFactory clientFactory = GWT.create(ClientFactory.class);
		EventBus eventBus = clientFactory.getEventBus();

		AppLayout appLayout = new AppLayoutImpl(clientFactory);

		// Main Panel Content container Activity Mapper
		MainPanelContentActivityMapper mainPanelActivityMapper = new MainPanelContentActivityMapper(clientFactory);
		ActivityManager mainPanelActivityManager = new ActivityManager(mainPanelActivityMapper, eventBus);
		mainPanelActivityManager.setDisplay(appLayout.getMainPanelContainer());

		// Right Panel Content container Activity Mapper
		RightPanelContentActivityMapper rightPanelActivityMapper = new RightPanelContentActivityMapper(clientFactory);
		ActivityManager rightPanelActivityManager = new ActivityManager(rightPanelActivityMapper, eventBus);
		rightPanelActivityManager.setDisplay(appLayout.getRightPanelContainer());

		AppPlaceHistoryMapper historyMapper = GWT.create(AppPlaceHistoryMapper.class);

		PlaceController placeController = clientFactory.getPlaceController();
		PlaceHistoryHandler historyHandler = new PlaceHistoryHandler(historyMapper);
		historyHandler.register(placeController, eventBus, defaultPlace);

		RootLayoutPanel.get().add(appLayout.getMainLayoutPanel());
		new AppController(appLayout, clientFactory);

		historyHandler.handleCurrentHistory();
	}
	
    @Override
	public void onModuleLoad() {

		GWT.setUncaughtExceptionHandler(new GWT.UncaughtExceptionHandler() {

			@Override
			public void onUncaughtException(Throwable e) {
				//TODO put in your own meaninful handler
				Window.alert("uncaught: " + e.getMessage());
				e.printStackTrace();
			}
		});

		new Timer() {
			@Override
			public void run() {
				start();

			}
		}.schedule(1);	
	}
}

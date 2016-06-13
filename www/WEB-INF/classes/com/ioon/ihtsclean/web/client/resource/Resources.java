package com.ioon.ihtsclean.web.client.resource;

import com.google.gwt.core.client.GWT;
import com.google.gwt.resources.client.ClientBundle;
import com.google.gwt.resources.client.CssResource;
import com.google.gwt.resources.client.CssResource.NotStrict;
import com.google.gwt.resources.client.ImageResource;

public interface Resources extends ClientBundle {

	public static final Resources INSTANCE = GWT.create(Resources.class);

	@Source("images/logo.png")
	ImageResource logo();
	
	@Source("images/loading.gif")
	ImageResource loading();
	
	@Source("images/return.jpg")
	ImageResource returnIcon();
	
	@Source("images/save.jpg")
	ImageResource save();
	
	@Source("images/print.jpg")
	ImageResource print();
	
	@Source("images/document.jpg")
	ImageResource document();
	
	@Source("images/cancel.jpg")
	ImageResource cancel();
	
	@Source("images/find.jpg")
	ImageResource find();
	
	@Source("images/new.jpg")
	ImageResource newIcon();
	
	@Source("images/delete.jpg")
	ImageResource delete();
	
	@Source("images/reject.jpg")
	ImageResource reject();
	
	@Source("images/validate.jpg")
	ImageResource validate();
	
	@Source("images/albaran.jpg")
	ImageResource albaran();
	
	@Source("images/albaranSinEurowin.jpg")
	ImageResource albaranSinEurowin();
	
	@Source("images/ihtsClean.png")
	ImageResource brandImage();

	@NotStrict
	@Source("css/App.css")
	MyCssResources css();

	interface MyCssResources extends CssResource {

		String tableHeader();

		String tableRowPair();

		String tableRowOdd();
	}
}

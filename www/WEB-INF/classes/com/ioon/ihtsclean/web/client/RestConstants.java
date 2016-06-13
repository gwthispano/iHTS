package com.ioon.ihtsclean.web.client;

import com.google.gwt.i18n.client.Constants;

public interface RestConstants extends Constants {
	
	//HEADERS
	String contentType();
	String contentTypeJson();
	String contentTypeText();
	String authorization();	
	String authorizationBasicType();	
	
	//REST URLs
	String urlPrefix();
	String loginUrl();
}

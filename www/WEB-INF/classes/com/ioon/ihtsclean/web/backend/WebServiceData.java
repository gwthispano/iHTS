package com.ioon.ihtsclean.web.backend;

import com.google.gwt.core.client.GWT;
import com.ioon.ihtsclean.web.client.RestConstants;
import com.ioon.ihtscommon.web.client.backend.Base64Utils;

public class WebServiceData {

	private static RestConstants restConstants = GWT.create(RestConstants.class);

	//HEADER
	public static String getContentType(){
		return restConstants.contentType();
	}
	
	public static String getContentTypeJson() {
		return restConstants.contentTypeJson();
	}

	public static String getContentTypeText() {
		return restConstants.contentTypeText();
	}
	
	public static String getAuthorizationKey(){
		return restConstants.authorization();
	}
	
	public static String getAuthorizationBasicType(){
		return restConstants.authorizationBasicType();
	}
	
	public static String getAuthorizationContent(String user, String password, String authorizationType){
		
		StringBuilder content = new StringBuilder();
		
		content.append(authorizationType);
		content.append(" ");
		content.append(Base64Utils.toBase64((user+":"+password).getBytes()));
		
		return content.toString();
	}

	//REST URLs
	
	public static String loginUrlPOST() {
		return restConstants.urlPrefix() + restConstants.loginUrl();
	}
}

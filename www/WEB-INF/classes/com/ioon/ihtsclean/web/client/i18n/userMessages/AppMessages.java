package com.ioon.ihtsclean.web.client.i18n.userMessages;

import com.google.gwt.i18n.client.Messages;

public interface AppMessages extends Messages {

	String generalError();
	String invalidDataLogin();
	
	//MESSAGE FROM BACKEND ERROR RESPONSE
	String invalidUserPassword();
	String disabledUser();
}

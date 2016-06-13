package com.ioon.ihtsclean.web.backend;

/**
 * View interface. Extends IsWidget so a view impl can easily provide its
 * container widget.
 */
public abstract class AppRequest {
	
	public AppRequest(){
	}
	
	public abstract void get(String url);

	public abstract void postLogin(String url, String contentType, String user, String password);
	
	public abstract void post(String url, String payload, String contentType);
	
	public abstract void setListener(AppRequestListener listener);

	public interface AppRequestListener {
		void requestOk(String textResponse);
		void requestException(Throwable exception);
	}
}
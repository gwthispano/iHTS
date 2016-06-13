package com.ioon.ihtsclean.web.backend.user;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class UserListResponseOK extends JavaScriptObject {

	protected UserListResponseOK() {
	}

	public final native String getType() /*-{
		return this.type;
	}-*/;

	public final native String getDate() /*-{
		return this.date;
	}-*/;

	public final native JsArray<PayloadResponseOK> getPayload() /*-{
		return this.payload;
	}-*/;

	public final native static UserListResponseOK asListResponseOK(String json) /*-{
		eval('var res = ' + json);
		return res;
	}-*/;

	public static class PayloadResponseOK extends JavaScriptObject {

		protected PayloadResponseOK() {
		}

		public final native int getId() /*-{
			return this.id;
		}-*/;

		public final native String getUserName() /*-{
			return this.username;
		}-*/;

		public final native String getPassword() /*-{
			return this.password;
		}-*/;

		public final native String getExternalId() /*-{
			return this.externalId;
		}-*/;
		
		public final native String getName() /*-{
			return this.nombre;
		}-*/;
		
		public final native String getEmail() /*-{
			return this.email;
		}-*/;

		public final native String getRole() /*-{
			return this.role;
		}-*/;
	}

}
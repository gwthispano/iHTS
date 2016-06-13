package com.ioon.ihtsclean.web.backend.user;

import com.google.gwt.core.client.JavaScriptObject;
import com.google.gwt.core.client.JsArray;

public class UserListResponseTest extends JavaScriptObject {

	protected UserListResponseTest() {
	}

	public final native String getType() /*-{
		return this.type;
	}-*/;

	public final native String getDate() /*-{
		return this.date;
	}-*/;

	public final native JsArray<UserResponseTest> getUsers() /*-{
		return this.payload;
	}-*/;

	public final native static JsArray<UserResponseTest> asListResponseOK(String json) /*-{
		eval('var res = ' + json);
		return res;
	}-*/;

	public static class UserResponseTest extends JavaScriptObject {

		protected UserResponseTest() {
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
			return this.name;
		}-*/;
		
		public final native String getEmail() /*-{
			return this.lastname;
		}-*/;

		public final native String getRole() /*-{
			return this.role;
		}-*/;
		
		public final native String getLastname() /*-{
		return this.role;
	}-*/;
	}

}
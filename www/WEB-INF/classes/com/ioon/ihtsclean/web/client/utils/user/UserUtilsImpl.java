package com.ioon.ihtsclean.web.client.utils.user;

import java.util.ArrayList;
import java.util.List;

import com.google.gwt.core.shared.GWT;
import com.ioon.ihtsclean.web.backend.AppRequest;
import com.ioon.ihtsclean.web.backend.AppRequestImpl;
import com.ioon.ihtsclean.web.backend.WebServiceData;
import com.ioon.ihtsclean.web.backend.user.UserListResponseOK;
import com.ioon.ihtsclean.web.client.AppConstants;

public class UserUtilsImpl implements UserUtils {
	
	/*private AppConstants constants = GWT.create(AppConstants.class);
	private UtilsListener listener;

	public UserUtilsImpl() {
	}
	
	@Override
	public void getById(int id) {
		GetRequest get = new GetRequest();
		get.send(id);
	}
	

	@Override
	public void getByWorkerNumber(int number) {
		GetForExternalIdRequest get = new GetForExternalIdRequest();
		get.send(number);
	}
	
	@Override
	public void getList() {	
		GetListRequest getList = new GetListRequest();
		getList.send();
	}
	
	@Override
	public void getList(String role) {	
		GetListRoleRequest getList = new GetListRoleRequest();
		getList.send(role);
	}
	
	@Override
	public void add(User object) {
		AddRequest addRequest = new AddRequest();
		addRequest.send(object);
	}
	
	@Override
	public void update(User object) {
		UpdateRequest updateRequest = new UpdateRequest();
		updateRequest.send(object);
	}
	
	@Override
	public void delete(User object) {
		DeleteRequest deleteRequest = new DeleteRequest();
		deleteRequest.send(object);
	}
	
	@Override
	public void setListener(UtilsListener listener) {
		this.listener = listener;
	}
	

	
	public class GetListRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public GetListRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send() {
			request.get(WebServiceData.urlGET(constants.urlEntityUser()));
		}		

		@Override
		public void requestOk(String textResponse) {
			try {
				listener.resultOk(getJsonResult(textResponse));
			} catch (Exception e) {
				requestException(e);
			}
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
	
	public class GetListRoleRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public GetListRoleRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous				
		public void send(String role) {
			request.get(WebServiceData.urlWhitRoleGET(constants.urlEntityUser(), role));
		}	

		@Override
		public void requestOk(String textResponse) {
			try {
				listener.resultOk(getJsonResult(textResponse));
			} catch (Exception e) {
				requestException(e);
			}
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
	
	public class GetRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public GetRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send(int id) {
			request.get(WebServiceData.urlWithIdGET(constants.urlEntityUser(), id));
		}		

		@Override
		public void requestOk(String textResponse) {
			try {
				listener.resultOk(getJsonResult(textResponse));
			} catch (Exception e) {
				requestException(e);
			}
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
	
	public class GetForExternalIdRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public GetForExternalIdRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send(int number) {
			request.get(WebServiceData.urlForExternalIdUserGET(constants.urlEntityUser(), number));
		}		

		@Override
		public void requestOk(String textResponse) {
			try {
				listener.resultOk(getJsonResult(textResponse));
			} catch (Exception e) {
				requestException(e);
			}
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
		
	public class AddRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public AddRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send(User object) {
			request.post(WebServiceData.urlAddPOST(constants.urlEntityUser()), WebServiceData.userJsonParamsAddPOST(object), WebServiceData.getContentTypeJson());
		}		

		@Override
		public void requestOk(String textResponse) {
			ArrayList<User> list = new ArrayList<User>();
			listener.resultOk(list);
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
	
	public class UpdateRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public UpdateRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send(User object) {
			request.post(WebServiceData.urlUpdatePOST(constants.urlEntityUser()), WebServiceData.userJsonParamsUpdatePOST(object), WebServiceData.getContentTypeJson());
		}		

		@Override
		public void requestOk(String textResponse) {
			ArrayList<User> list = new ArrayList<User>();
			listener.resultOk(list);
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}
	
	public class DeleteRequest implements AppRequest.AppRequestListener {

		private AppRequest request;
		
		public DeleteRequest() {
			request = new AppRequestImpl();
			request.setListener(this);
		}
		
		//Asincronous
		public void send(User object) {
			request.post(WebServiceData.urlDeletePOST(
					constants.urlEntityUser(), object.getId()), null, WebServiceData.getContentTypeText());
		}		

		@Override
		public void requestOk(String textResponse) {
			ArrayList<User> list = new ArrayList<User>();
			listener.resultOk(list);
		}

		@Override
		public void requestException(Throwable exception) {
			listener.resultException(exception);
		}
	}*/
}

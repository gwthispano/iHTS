package com.ioon.ihtsclean.web.backend;

import com.google.gwt.http.client.Request;
import com.google.gwt.http.client.RequestBuilder;
import com.google.gwt.http.client.RequestCallback;
import com.google.gwt.http.client.RequestException;
import com.google.gwt.http.client.Response;
import com.ioon.ihtsclean.web.client.utils.Utils;
import com.ioon.ihtscommon.web.client.AppException;
import com.ioon.ihtscommon.web.client.backend.ConstantHttpResponse;
import com.ioon.ihtscommon.web.client.backend.ResponseError;
import com.allen_sauer.gwt.log.client.Log;

public class AppRequestImpl extends AppRequest {
	
	private AppRequestListener listener;

	public AppRequestImpl() {
		super();
	}

	@Override
	public void get(String url) {
		Log.info("GET url: "+url);
		
		RequestBuilder builder = new RequestBuilder(RequestBuilder.GET, url);

		try {
			builder.sendRequest(null,
					new RequestCallback() {
						public void onError(Request request, Throwable exception) {
							listener.requestException(exception);
						}

						public void onResponseReceived(Request request,
								Response response) {
							
							try {
								listener.requestOk(getDataFromHttpResponse(response));
								
							} catch (Exception e) {
								listener.requestException(e);
							}
						}
					});
		} catch (RequestException e) {
			listener.requestException(e);
		}
	}
	
	@Override
	public void postLogin(String url, String contentType, String user, String password) {
		Log.info("POST url: "+url);
		
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url);
		
		requestBuilder.setHeader(WebServiceData.getAuthorizationKey(), WebServiceData.getAuthorizationContent(user, password, WebServiceData.getAuthorizationBasicType()));
		requestBuilder.setHeader(WebServiceData.getContentType(), WebServiceData.getContentTypeJson());
		
		try {
			requestBuilder.sendRequest("",
					new RequestCallback() {
						public void onError(Request request, Throwable exception) {
							listener.requestException(exception);
						}

						public void onResponseReceived(Request request,
								Response response) {
							
							try {
								listener.requestOk(getDataFromHttpResponse(response));
								
							} catch (Exception e) {
								listener.requestException(e);
							}
						}
					});
		} catch (RequestException e) {
			listener.requestException(e);
		}
	}

	@Override
	public void post(String url, String payload, String contentType) {
		Log.info("POST url: "+url+"\npayload: "+payload+"\nContent-Type: "+contentType);
		
		RequestBuilder requestBuilder = new RequestBuilder(RequestBuilder.POST, url);
		
		requestBuilder.setHeader(WebServiceData.getContentType(), WebServiceData.getContentTypeJson());
		
		try {
			requestBuilder.sendRequest(payload,
					new RequestCallback() {
						public void onError(Request request, Throwable exception) {
							listener.requestException(exception);
						}

						public void onResponseReceived(Request request,
								Response response) {
							
							try {
								listener.requestOk(getDataFromHttpResponse(response));
								
							} catch (Exception e) {
								listener.requestException(e);
							}
						}
					});
		} catch (RequestException e) {
			listener.requestException(e);
		}
	}
	
	@Override
	public void setListener(AppRequestListener listener) {
		this.listener = listener;	
	}
	
	private String getDataFromHttpResponse(Response response) throws AppException {
		String result = null;
		
		Log.debug("http response status: "+response.getStatusCode()+" - "+response.getStatusText());
		Log.debug("http response text: "+response.getText());
		
		if (ConstantHttpResponse.OK == response.getStatusCode()) {
			result = response.getText();
			
		} else {
			ResponseError errorResponse = ResponseError.asResponseError(response.getText());
			
			throw new AppException(Utils.getMessageFromErrorCode(errorResponse.getError()), response.getStatusCode(), response.getStatusText(), response.getText());
		}
		
		return result;
	}
}

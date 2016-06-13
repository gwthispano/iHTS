package com.ioon.ihtsclean.web.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AppLoginPlace extends Place
{	
	public static class Tokenizer implements PlaceTokenizer<AppLoginPlace>
	{

		@Override
		public String getToken(AppLoginPlace place)
		{
			return "";
		}

		@Override
		public AppLoginPlace getPlace(String token)
		{
			return new AppLoginPlace();
		}

	}
}

package com.ioon.ihtsclean.web.client.place;

import com.google.gwt.place.shared.Place;
import com.google.gwt.place.shared.PlaceTokenizer;

public class AppHomePlace extends Place
{	
	public static class Tokenizer implements PlaceTokenizer<AppHomePlace>
	{

		@Override
		public String getToken(AppHomePlace place)
		{
			return "";
		}

		@Override
		public AppHomePlace getPlace(String token)
		{
			return new AppHomePlace();
		}

	}
}

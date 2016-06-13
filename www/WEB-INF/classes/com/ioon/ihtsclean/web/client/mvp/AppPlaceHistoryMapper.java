package com.ioon.ihtsclean.web.client.mvp;

import com.google.gwt.place.shared.PlaceHistoryMapper;
import com.google.gwt.place.shared.WithTokenizers;
import com.ioon.ihtsclean.web.client.place.AppHomePlace;
import com.ioon.ihtsclean.web.client.place.AppLoginPlace;

@WithTokenizers({
    AppLoginPlace.Tokenizer.class,
    AppHomePlace.Tokenizer.class
})

public interface AppPlaceHistoryMapper extends PlaceHistoryMapper {
}

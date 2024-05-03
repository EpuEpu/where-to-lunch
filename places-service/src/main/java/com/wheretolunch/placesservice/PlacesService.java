package com.wheretolunch.placesservice;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.LatLng;
import com.google.maps.model.PlaceType;
import com.google.maps.model.PlacesSearchResponse;
import com.google.maps.model.RankBy;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

@Service
public class PlacesService {

    @Value("${google.maps.api-key}")
    private String apiKey;

    public PlacesSearchResponse findRestaurants(double latitude, double longitude) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        LatLng location = new LatLng(latitude, longitude);

        return PlacesApi.nearbySearchQuery(context, location)
                .type(PlaceType.RESTAURANT)
                .radius(5000) // set the radius in meters
                .rankby(RankBy.PROMINENCE)
                .await();
    }
}

package com.wheretolunch.placesservice;

import com.google.maps.GeoApiContext;
import com.google.maps.PlacesApi;
import com.google.maps.model.*;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PlacesService {

    @Value("${google.maps.api-key}")
    private String apiKey;

    public List<PlacesSearchResult> findRestaurants(double latitude, double longitude) throws Exception {
        GeoApiContext context = new GeoApiContext.Builder()
                .apiKey(apiKey)
                .build();

        LatLng location = new LatLng(latitude, longitude);
        PlacesSearchResponse response = PlacesApi.nearbySearchQuery(context, location)
                .type(PlaceType.RESTAURANT)
                .radius(500)
                .rankby(RankBy.PROMINENCE)
                .await();

        List<PlacesSearchResult> allResults = new ArrayList<>(List.of(response.results));

        while (response.nextPageToken != null && !response.nextPageToken.isEmpty()) {
            Thread.sleep(2000);
            response = PlacesApi.nearbySearchNextPage(context, response.nextPageToken).await();
            allResults.addAll(List.of(response.results));
        }

        return allResults;
    }
}

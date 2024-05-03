package com.wheretolunch.placesservice;

import com.google.maps.model.PlacesSearchResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class PlacesController {

    @Autowired
    private PlacesService placesService;

    @GetMapping("/restaurants/{lat}/{lng}")
    public List<PlacesSearchResult> getRestaurants(@PathVariable double lat, @PathVariable double lng) {
        try {
            return placesService.findRestaurants(lat, lng);
        } catch (Exception e) {
            return null;
        }
    }
}

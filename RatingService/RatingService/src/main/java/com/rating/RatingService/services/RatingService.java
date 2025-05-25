package com.rating.RatingService.services;

import com.rating.RatingService.entity.Rating;

import java.util.List;

public interface RatingService {

    //create
    Rating getRating(Rating rating);

    //getAllRatings
    List<Rating> getAllRatings();

    //getAllByUserId
    List<Rating> getRatingByUserId(String userId);

    //getAllHotel
    List<Rating> getRatingByHotelId(String hotelId);

}

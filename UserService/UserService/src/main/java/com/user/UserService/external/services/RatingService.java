package com.user.UserService.external.services;

import com.user.UserService.entities.Ratings;
import jakarta.ws.rs.Path;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;

import java.util.Map;

@FeignClient("RATINGSERVICE")
public interface RatingService {


    @PostMapping("/ratings")
    public Ratings createRatings(Ratings values);


    @PutMapping("/ratings/{ratingId}")
    public Ratings updateRatings(@PathVariable("ratingId") String ratingId, Ratings values);

    @DeleteMapping("/ratings/ratingId")
    public void deleteRating(@PathVariable("ratingId") String ratingId);

}

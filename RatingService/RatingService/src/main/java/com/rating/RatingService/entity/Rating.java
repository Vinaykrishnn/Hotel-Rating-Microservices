package com.rating.RatingService.entity;

import jakarta.persistence.*;

import java.lang.annotation.Documented;

@Entity
@Table(name = "v_rating_dtl")
public class Rating {

    @Id
    @Column(name = "v_rating_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 1)
    private long ratingId;

    @Column(name = "v_rating_user_id")
    private String userId;

    @Column(name = "v_rating_hotel_id")
    private String hotelId;

    @Column(name = "v_rating")
    private String rating;

    @Column(name = "v_rating_feedback")
    private String feedback;

    public Rating(){

    }

    public long getRatingId() {
        return ratingId;
    }

    public void setRatingId(long ratingId) {
        this.ratingId = ratingId;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getHotelId() {
        return hotelId;
    }

    public void setHotelId(String hotelId) {
        this.hotelId = hotelId;
    }

    public String getRating() {
        return rating;
    }

    public void setRating(String rating) {
        this.rating = rating;
    }

    public String getFeedback() {
        return feedback;
    }

    public void setFeedback(String feedback) {
        this.feedback = feedback;
    }
}

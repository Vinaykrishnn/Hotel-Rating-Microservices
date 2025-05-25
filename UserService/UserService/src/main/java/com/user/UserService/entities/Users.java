package com.user.UserService.entities;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@AllArgsConstructor
//@NoArgsConstructor
@Builder
@Entity
@Table(name = "v_users_dtl")
public class Users {

    @Id
    @Column(name = "v_user_id")
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "user_seq")
    @SequenceGenerator(name = "user_seq", sequenceName = "user_sequence", initialValue = 1000, allocationSize = 1)
    private long userId;

    @Column(name = "v_user_name")
    private String userName;

    @Column(name = "v_user_email")
    private String userEmail;

    @Column(name = "v_user_about")
    private String aboutUser;

    @Transient
    private List<Ratings> ratings = new ArrayList<>();


    public List<Ratings> getRatings() {
        return ratings;
    }

    public void setRatings(List<Ratings> ratings) {
        this.ratings = ratings;
    }

    public Users(){

    }
    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getUserEmail() {
        return userEmail;
    }

    public void setUserEmail(String userEmail) {
        this.userEmail = userEmail;
    }

    public String getAboutUser() {
        return aboutUser;
    }

    public void setAboutUser(String aboutUser) {
        this.aboutUser = aboutUser;
    }
}

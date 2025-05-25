package com.user.UserService.impl;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.user.UserService.entities.Hotel;
import com.user.UserService.entities.Ratings;
import com.user.UserService.entities.Users;
import com.user.UserService.exceptions.ResourceNotFoundException;
import com.user.UserService.repositoy.UserRepository;
import com.user.UserService.services.UserService;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.logging.Logger;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private UserRepository userRepository;

    private org.slf4j.Logger logger = (org.slf4j.Logger) LoggerFactory.getLogger(UserServiceImpl.class);
    @Override
    public Users saveUser(Users users) {
//        String randomUserId = UUID.randomUUID().toString();
//        users.setUserId(randomUserId);
        return userRepository.save(users);
    }

    @Override
    public List<Users> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public Users getUsers(String userId) {
        Users users = userRepository.findById(userId)
                .orElseThrow(() -> new ResourceNotFoundException("User not found with user id = " + userId));

        // Step 1: Get list of ratings from Rating Service
        ArrayList<?> listOfUsers = restTemplate.getForObject(
                "http://RATINGSERVICE/ratings/users/" + users.getUserId(),
                ArrayList.class
        );

        // Step 2: Convert LinkedHashMap to Ratings using ObjectMapper
        ObjectMapper mapper = new ObjectMapper();

        List<Ratings> ratingsList = listOfUsers.stream().map(obj -> {
            Ratings rating = mapper.convertValue(obj, Ratings.class);

            // Step 3: Get Hotel for each rating
            ResponseEntity<Hotel> response = restTemplate.getForEntity(
                    "http://HOTELSERVICE/hotels/" + rating.getHotelId(),
                    Hotel.class
            );
            rating.setHotel(response.getBody());
            return rating;
        }).collect(Collectors.toList());

        // Step 4: Set ratings and return user
        users.setRatings(ratingsList);
        return users;
    }
}

package com.user.UserService;

import com.user.UserService.entities.Ratings;
import com.user.UserService.external.services.RatingService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Service;

@Service
@SpringBootTest
class UserServiceApplicationTests {

	@Test
	void contextLoads() {

	}

//	@Autowired
//	private RatingService ratingService;
//	void createRatings(){
//		Ratings ratings = Ratings.builder().build().rating();
//		ratingService.createRatings();
//	}

}

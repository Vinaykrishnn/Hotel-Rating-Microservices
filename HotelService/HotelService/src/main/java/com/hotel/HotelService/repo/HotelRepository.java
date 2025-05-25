package com.hotel.HotelService.repo;

import com.hotel.HotelService.entities.Hotel;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HotelRepository extends JpaRepository<Hotel, String> {

//    Hotel delete(String id);
}

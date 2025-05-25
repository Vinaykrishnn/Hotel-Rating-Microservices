package com.hotel.HotelService.controller;

import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.services.HotelService;
import com.hotel.HotelService.services.HotelServiceImpl;
import org.apache.coyote.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/hotels")
public class HotelController {

    @Autowired
    private HotelServiceImpl hotelService;

    @PostMapping
    public ResponseEntity<Hotel> createHotel(@RequestBody Hotel hotel){
        return ResponseEntity.status(HttpStatus.CREATED).body(hotelService.create(hotel));
    }

    @GetMapping("/{hotelId}")
    public ResponseEntity<Hotel> getHotelById(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.status(HttpStatus.OK).body(hotelService.get(hotelId));
    }

    @GetMapping
    public ResponseEntity<List<Hotel>> getAllHotels(){
        return ResponseEntity.ok(hotelService.getAll());
    }

    @DeleteMapping("/{hotelId}")
    public ResponseEntity<Hotel> deleteHotel(@PathVariable("hotelId") String hotelId){
        return ResponseEntity.ok(hotelService.delete(hotelId));
    }
}

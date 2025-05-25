package com.hotel.HotelService.services;

import com.hotel.HotelService.entities.Hotel;
import com.hotel.HotelService.exception.ResourceNotFoundException;
import com.hotel.HotelService.repo.HotelRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImpl implements HotelService{

    @Autowired
    private HotelRepository hotelRepository;

    @Override
    public Hotel create(Hotel hotel) {
        return hotelRepository.save(hotel);
    }

    @Override
    public List<Hotel> getAll() {
        return hotelRepository.findAll();
    }

    @Override
    public Hotel get(String id) {
        return hotelRepository.findById(id).orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));
    }

    @Override
    public Hotel delete(String id) {
        Hotel hotel = hotelRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Hotel with given id not found"));

        hotelRepository.delete(hotel);
        return hotel; // return deleted hotel info
    }



}

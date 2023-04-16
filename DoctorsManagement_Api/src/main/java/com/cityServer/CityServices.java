package com.cityServer;

import java.util.List;

import org.springframework.stereotype.Service;

import com.entity.City;
@Service
public interface CityServices {
    public City inserCity(City city);
    public List<City> getAll();
    public City getByName(String name);
    public String deleteCity(String name);
    
}

package com.dector_repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.entity.City;

public interface CityRepo extends JpaRepository<City, Integer>{
   public City findByName(String name);
}

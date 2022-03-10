package com.project.CityService.repository;

import com.project.CityService.model.City;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface CityRepository extends MongoRepository<City,String> {
}

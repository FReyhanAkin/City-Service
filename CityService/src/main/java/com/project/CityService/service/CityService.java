package com.project.CityService.service;


import com.project.CityService.model.City;
import com.project.CityService.repository.CityRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class CityService {
    private final CityRepository cityRepository;

    public List<City> getCity() {
        return cityRepository.findAll();
    }

    public City createCity(City newCity) {
        return cityRepository.save(newCity);
    }

    public void deleteCity(String id) {
        cityRepository.deleteById(id);
    }

    public City getCityById(String id) {
        return cityRepository.findById(id)
                .orElseThrow(()->new RuntimeException("Il not found"));
    }

    public void updateCity(String id, City newCity) {
        City oldCity=getCityById(id);
        oldCity.setName(newCity.getName());
        cityRepository.save(oldCity);
    }
}

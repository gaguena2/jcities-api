package com.gaguena.jdemo.city;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CityService{

    @Autowired
    private CityRepository cityRepository;
    
    public Optional<City> getBy(Long code) {
       var cities = this.cityRepository.findByCode(code);
       return cities;
    }

    public City create(CityData state) {
       return this.cityRepository.save(state.toCity());
    }

    public List<City> saveAll(List<CityData> datas) {
        var cities = datas.stream().map(CityData::toCity).toList();
        return cities.stream().map(this.cityRepository::save).toList();
    }

    public List<City> getBy(String uf) {
        return this.cityRepository.findByUf(uf);
    }
    
}
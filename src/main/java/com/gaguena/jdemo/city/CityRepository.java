package com.gaguena.jdemo.city;

import java.util.List;
import java.util.Optional;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CityRepository extends MongoRepository<City, String> {

    Optional<City> findByCode(Long code);

    List<City> findByUf(String uf);

}

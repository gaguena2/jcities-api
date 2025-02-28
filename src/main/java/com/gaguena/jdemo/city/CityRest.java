package com.gaguena.jdemo.city;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cities")
public class CityRest {

    @Autowired
    private CityService cityService;

    @GetMapping("/{code}")
    public ResponseEntity<CityData> get(@PathVariable Long code) {
        return this.cityService.getBy(code).map(CityData::toCityData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/")
    public ResponseEntity<List<CityData>> create(@RequestBody List<CityData> datas) {
        var cities = this.cityService.saveAll(datas)
                .stream()
                .map(CityData::toCityData)
                .toList();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(cities);
    }
}
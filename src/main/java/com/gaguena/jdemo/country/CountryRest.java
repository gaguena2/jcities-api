package com.gaguena.jdemo.country;

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
@RequestMapping("/countries")
public class CountryRest {

    @Autowired
    private CountryService countryService;

    @GetMapping("/{code}")
    public ResponseEntity<CountryData> get(@PathVariable Long code) {
        return this.countryService.getBy(code).map(CountryData::toCountryData)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.status(HttpStatus.NOT_FOUND).build());
    }

    @PostMapping("/")
    public ResponseEntity<List<CountryData>> create(@RequestBody List<CountryData> datas) {
        var countries = this.countryService.saveAll(datas)
                .stream()
                .map(CountryData::toCountryData)
                .toList();
        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(countries);
    }
}

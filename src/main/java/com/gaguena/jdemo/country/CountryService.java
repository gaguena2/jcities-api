package com.gaguena.jdemo.country;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CountryService {

    @Autowired
    private CountryRepository countryRepository;

    public Optional<Country> getBy(Long code) {
        return this.countryRepository.findByCode(code);
    }

    public Country create(CountryData country) {
        return this.countryRepository.save(country.toCountry());
    }

    public List<Country> saveAll(List<CountryData> datas) {
        var countries = datas.stream().map(CountryData::toCountry).toList();
        return countries.stream().map(this.countryRepository::save).toList();
    }

    public Optional<Country> getBy(String uf) {
        return this.countryRepository.findByUf(uf);
    }
}

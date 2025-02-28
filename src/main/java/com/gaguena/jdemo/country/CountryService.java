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

    public Country create(Country state) {
       return this.countryRepository.save(state);
    }

    public List<Country> saveAll(List<CountryData> datas) {
        var sates = datas.stream().map(CountryData::toCountry).toList();
        return sates.stream().map(this.countryRepository::save).toList();
    }
}

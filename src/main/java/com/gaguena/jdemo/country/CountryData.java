package com.gaguena.jdemo.country;

import java.util.Collections;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.gaguena.jdemo.city.City;
import com.gaguena.jdemo.city.CityData;

@JsonInclude(JsonInclude.Include.NON_EMPTY)
public record CountryData(Long code, String name, String uf, int region, List<CityData> cities) {
    public Country toCountry() {
        var state = new Country();
        state.setCode(this.code);
        state.setName(this.name);
        state.setRegion(this.region);
        state.setUf(this.uf);
        return state;
    }


    public static CountryData toCountryData(Country state) {
        return new CountryData(state.getCode(), state.getName(), state.getUf(), state.getRegion(), Collections.emptyList());
    }
    public static CountryData toCountryData(Country state, List<City> cities) {
        var citiesData = cities.stream().map(CityData::toCityData).toList();
        return new CountryData(state.getCode(), state.getName(), state.getUf(), state.getRegion(), citiesData);
    }
}

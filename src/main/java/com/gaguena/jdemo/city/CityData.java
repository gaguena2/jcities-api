package com.gaguena.jdemo.city;

public record CityData(Long code, String name, String uf) {

    public City toCity() {
        var city = new City();
        city.setCode(this.code);
        city.setName(this.name);
        city.setUf(this.uf);
        return city;
    }
    
    public static CityData toCityData(City city) {
        return new CityData(city.getCode(), city.getName(), city.getUf());
    }
}

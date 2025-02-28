package com.gaguena.jdemo.country;

public record CountryData(Long code, String name, String uf, int region) {
    public Country toCountry() {
        var state = new Country();
        state.setCode(this.code);
        state.setName(this.name);
        state.setRegion(this.region);
        state.setUf(this.uf);
        return state;
    }

    public static CountryData toCountryData(Country state) {
        return new CountryData(state.getCode(), state.getName(), state.getUf(), state.getRegion());
    }
}

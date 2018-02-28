package lab.dao;

import lab.model.Country;
import lab.model.simple.SimpleCountry;

import java.util.Arrays;
import java.util.List;

public interface CountryDao {
    String[][] COUNTRY_INIT_DATA = {
            {"Australia", "AU"},
            {"Canada", "CA"},
            {"France", "FR"},
            {"Hong Kong", "HK"},
            {"Iceland", "IC"},
            {"Japan", "JP"},
            {"Nepal", "NP"},
            {"Russian Federation", "RU"},
            {"Sweden", "SE"},
            {"Switzerland", "CH"},
            {"United Kingdom", "GB"},
            {"United States", "US"}};

    List<Country> getCountries();

    List<Country> getCountriesStartWith(String name);

    void updateCountryName(String codeName, String newCountryName);

    default void loadCountries() {
        Arrays.stream(COUNTRY_INIT_DATA)
                .map(countryInitData -> SimpleCountry.builder()
                        .name(countryInitData[0])
                        .codeName(countryInitData[1])
                        .build())
                .forEach(this::save);
    }

    Country getCountryByCodeName(String codeName);

    Country getCountryByName(String name) throws CountryNotFoundException;

    Country save(Country country);
}

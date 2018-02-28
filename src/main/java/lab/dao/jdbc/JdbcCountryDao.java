package lab.dao.jdbc;

import lab.dao.CountryDao;
import lab.dao.CountryNotFoundException;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.val;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcDaoSupport;
import org.springframework.jdbc.support.GeneratedKeyHolder;
import org.springframework.jdbc.support.KeyHolder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

import static java.sql.Statement.RETURN_GENERATED_KEYS;

@Repository
public class JdbcCountryDao extends NamedParameterJdbcDaoSupport implements CountryDao {

    private static final String SAVE_COUNTRY_SQL = "INSERT INTO country (name, code_name) VALUES (?, ?)";
    private static final String GET_ALL_COUNTRIES_SQL = "SELECT id, name, code_name FROM country";
    private static final String GET_COUNTRIES_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name LIKE :name";
    private static final String GET_COUNTRY_BY_NAME_SQL = "SELECT id, name, code_name FROM country WHERE name = '%s'";
    private static final String GET_COUNTRY_BY_CODE_NAME_SQL = "SELECT id, name, code_name FROM country WHERE code_name = '%s'";
    private static final String UPDATE_COUNTRY_NAME_SQL = "UPDATE country SET name='%s' WHERE code_name='%s'";

    private static final RowMapper<Country> COUNTRY_ROW_MAPPER = (resultSet, i) ->
            SimpleCountry.builder()
                    .id(resultSet.getLong("id"))
                    .name(resultSet.getString("name"))
                    .codeName(resultSet.getString("code_name"))
                    .build();

    @Override
    public List<Country> getCountries() {
        return getJdbcTemplate().query(GET_ALL_COUNTRIES_SQL, COUNTRY_ROW_MAPPER);
    }

    @Override
    public List<Country> getCountriesStartWith(String name) {
        return getNamedParameterJdbcTemplate()
                .query(GET_COUNTRIES_BY_NAME_SQL,
                        Map.of("name", name + "%"),
                        COUNTRY_ROW_MAPPER);
    }

    @Override
    public void updateCountryName(String codeName, String newCountryName) {
        getJdbcTemplate().execute(
                String.format(UPDATE_COUNTRY_NAME_SQL, newCountryName, codeName));
    }

    @Override
    public void loadCountries() {
        for (String[] countryData : COUNTRY_INIT_DATA)
            save(countryData[0], countryData[1]);
    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        String sql = String.format(GET_COUNTRY_BY_CODE_NAME_SQL, codeName);
        return getJdbcTemplate().query(sql, COUNTRY_ROW_MAPPER).get(0);
    }

    @Override
    public Country getCountryByName(String name) throws CountryNotFoundException {
        List<Country> countries = getJdbcTemplate().query(
                String.format(GET_COUNTRY_BY_NAME_SQL, name),
                COUNTRY_ROW_MAPPER);

        if (countries.isEmpty())
            throw new CountryNotFoundException();

        return countries.get(0);
    }

    @Override
    public Country save(Country country) {
        assert country.getId() == null;
        return country.setId(
                save(country.getName(), country.getCodeName()));
    }

    private long save(String name, String codeName) {
        KeyHolder keyHolder = new GeneratedKeyHolder();
        getJdbcTemplate().update(
                connection -> {
                    val ps = connection.prepareStatement(
                            SAVE_COUNTRY_SQL, RETURN_GENERATED_KEYS);
                    ps.setString(1, name);
                    ps.setString(2, codeName);
                    return ps;
                },
                keyHolder);
        return keyHolder.getKey().longValue();
    }
}

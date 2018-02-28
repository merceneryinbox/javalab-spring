package orm;

import lab.dao.CountryDao;
import lab.dao.CountryNotFoundException;
import lab.model.Country;
import lab.model.simple.SimpleCountry;
import lombok.RequiredArgsConstructor;
import lombok.experimental.NonFinal;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Illustrates basic use of Hibernate as a JPA provider.
 */
@ExtendWith(SpringExtension.class)
@ContextConfiguration("classpath:orm.xml")
@RequiredArgsConstructor(onConstructor = @__(@Autowired))
class CountryDaoImplTest {

    private final static Country EXAMPLE_COUNTRY =
            new SimpleCountry(1L, "Australia", "AU");

    CountryDao countryDao;

    @NonFinal
    int size;

    @Test
    void testSaveCountry() {
        countryDao.save(EXAMPLE_COUNTRY);
        size++;

        List<Country> countries = countryDao.getCountries();
        assertEquals(1, countries.size());
        assertEquals(EXAMPLE_COUNTRY, countries.get(0));
    }

    @Test
    void testGtAllCountries() {
        countryDao.save(new SimpleCountry(1L, "Canada", "CA"));
        size++;

        assertEquals(size, countryDao.getCountries().size());
    }

    @Test
    void testGetCountryByName() throws CountryNotFoundException {
        countryDao.save(EXAMPLE_COUNTRY);
        size++;

        assertEquals(EXAMPLE_COUNTRY, countryDao.getCountryByName(EXAMPLE_COUNTRY.getName()));
    }
}

package orm;

import lab.dao.CountryDao;
import lab.dao.CountryNotFoundException;
import lab.model.Country;
import lab.model.SimpleCountry;
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
class CountryDaoImplTest {

    private Country exampleCountry = new SimpleCountry(1L, "Australia", "AU");

    @Autowired
    private CountryDao countryDao;

    private int size;

    @Test
    void testSaveCountry() {
        countryDao.save(exampleCountry);
        size++;

        List<Country> countries = countryDao.getCountries();
        assertEquals(1, countries.size());
        assertEquals(exampleCountry, countries.get(0));
    }

    @Test
    void testGtAllCountries() {
        countryDao.save(new SimpleCountry(1L, "Canada", "CA"));
        size++;

        assertEquals(size, countryDao.getCountries().size());
    }

    @Test
    void testGetCountryByName() throws CountryNotFoundException {
        countryDao.save(exampleCountry);
        size++;

        assertEquals(exampleCountry, countryDao.getCountryByName(exampleCountry.getName()));
    }
}

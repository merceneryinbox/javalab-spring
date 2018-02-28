package lab.dao.jpa;

import lab.dao.CountryDao;
import lab.model.Country;
import org.springframework.stereotype.Repository;

import java.util.List;

//@Repository("countryDao")
public class CountryJpaDaoImpl extends JpaDao implements CountryDao {

    @Override
    public Country save(Country country) {
        return mapEntityManagerInTransaction(entityManager ->
                entityManager.merge(country));
    }

    @Override
    public List<Country> getCountries() {
        return mapEntityManager(entityManager -> entityManager.createQuery(
                "select c from SimpleCountry c", Country.class)
                .getResultList());
    }

    @Override
    public List<Country> getCountriesStartWith(String name) {
        return null;
    }

    @Override
    public void updateCountryName(String codeName, String newCountryName) {

    }

    @Override
    public void loadCountries() {

    }

    @Override
    public Country getCountryByCodeName(String codeName) {
        return null;
    }

    @Override
    public Country getCountryByName(String name) {
        return mapEntityManager(entityManager ->
                entityManager
                        .createQuery(
                                "select c from SimpleCountry c where c.name like :name",
                                Country.class)
                        .setParameter("name", name)
                        .getSingleResult());
    }

}

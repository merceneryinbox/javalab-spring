package lab.service;

import lab.dao.CountryDao;
import lab.model.Country;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.transaction.annotation.Propagation.*;

@Repository // is more convenient declaration for such a class than general @Service
@AllArgsConstructor
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

    @SuppressWarnings("WeakerAccess")
    CountryDao jdbcCountryDao;

	public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {

		if (REQUIRED.equals(propagation)) {
			return getAllCountriesRequired();
		} else if (Propagation.REQUIRES_NEW.equals(propagation)) {
			return getAllCountriesRequiresNew();
		} else if (Propagation.SUPPORTS.equals(propagation)) {
			return getAllCountriesSupports();
		} else if (Propagation.NEVER.equals(propagation)) {
			return getAllCountriesNever();
		} else if (Propagation.MANDATORY.equals(propagation)) {
			return getAllCountriesMandatory();
		} else if (Propagation.NOT_SUPPORTED.equals(propagation)) {
			return getAllCountriesNotSupported();
		} else {
			return getAllCountries();
		}
	}

    @Transactional(propagation = REQUIRED)
	public List<Country> getAllCountriesRequired() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = REQUIRES_NEW)
    public List<Country> getAllCountriesRequiresNew() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = SUPPORTS)
    public List<Country> getAllCountriesSupports() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = NEVER)
    public List<Country> getAllCountriesNever() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = MANDATORY)
    public List<Country> getAllCountriesMandatory() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = NOT_SUPPORTED)
    public List<Country> getAllCountriesNotSupported() {
		return jdbcCountryDao.getCountries();
	}

    public List<Country> getAllCountries() {
		return jdbcCountryDao.getCountries();
	}

}
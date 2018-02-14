package lab.service;

import lab.dao.CountryDao;
import lab.model.Country;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

//@Repository is more convenient declaration for such a class than general @Service
@Repository
@AllArgsConstructor
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class CountryServiceImpl implements CountryService {

	private CountryDao jdbcCountryDao;

	@Transactional(propagation = Propagation.REQUIRED)
	public List<Country> getAllCountriesInsideTransaction(Propagation propagation) {

		if (Propagation.REQUIRED.equals(propagation)) {
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

    @Transactional(propagation = Propagation.REQUIRED)
	public List<Country> getAllCountriesRequired() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.REQUIRES_NEW)
	public List<Country> getAllCountriesRequiresNew() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.SUPPORTS)
	public List<Country> getAllCountriesSupports() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.NEVER)
	public List<Country> getAllCountriesNever() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.MANDATORY)
	public List<Country> getAllCountriesMandatory() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.NOT_SUPPORTED)
	public List<Country> getAllCountriesNotSupported() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public List<Country> getAllCountries() {
		return jdbcCountryDao.getCountries();
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public CountryDao getJdbcCountryDao() {
		return jdbcCountryDao;
	}

    @Transactional(propagation = Propagation.REQUIRED)
	public void setJdbcCountryDao(CountryDao jdbcCountryDao) {
		this.jdbcCountryDao = jdbcCountryDao;
	}

}
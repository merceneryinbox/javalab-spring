package lab.dao;

import javax.sql.DataSource;

public class CountryDao {
    String countryId;
    String countryDaoName;
    String countryDaoCodeName;
    DataSource dataSource;

    public CountryDao(DataSource dataSource) {
        this.dataSource = dataSource;
    }
}

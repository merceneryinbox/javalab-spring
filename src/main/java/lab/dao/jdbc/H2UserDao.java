package lab.dao.jdbc;

import lab.dao.UserDao;
import lab.model.simple.SimpleUser;
import lab.model.User;
import lombok.extern.log4j.Log4j2;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.support.JdbcDaoSupport;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Log4j2
public class H2UserDao extends JdbcDaoSupport implements UserDao {

    private static final RowMapper<User> USER_ROW_MAPPER = (rs, rowNum) ->
            new SimpleUser()
                    .setId(rs.getLong("id"))
                    .setFirstName(rs.getString("firstname"))
                    .setLastName(rs.getString("lastname"));

    @Override
    public void insert(User user) {

        if (user != null) {
            log.debug("Processing user: {}", user);
            getJdbcTemplate().update(
                    "insert into user (firstname, lastname) values (?, ?)",
                    user.getFirstName(), user.getLastName());
        } else
            log.debug("Domain user is null!");
    }

    @Override
    public Optional<User> select(int id) {

        User user = null;

        if (id > 0)
            user = getJdbcTemplate().queryForObject(
                    "select id, firstname, lastname from user where id = ?",
                    new Object[]{id}, USER_ROW_MAPPER);

        log.debug("Received user: {}", user);

        return Optional.ofNullable(user);
    }

    @Override
    public List<User> selectAll() {
        return getJdbcTemplate().query(
                "select id, firstname, lastname from user",
                USER_ROW_MAPPER);
    }
}

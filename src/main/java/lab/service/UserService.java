package lab.service;

import lab.dao.UserDao;
import lab.model.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.experimental.FieldDefaults;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static lombok.AccessLevel.PRIVATE;
import static org.springframework.transaction.annotation.Isolation.READ_COMMITTED;
import static org.springframework.transaction.annotation.Isolation.SERIALIZABLE;
import static org.springframework.transaction.annotation.Propagation.REQUIRES_NEW;
import static org.springframework.transaction.annotation.Propagation.SUPPORTS;

@Data
@Service
@Transactional
@AllArgsConstructor
@FieldDefaults(level = PRIVATE)
public class UserService {

	UserDao userDao;

	@Transactional(readOnly=true, propagation = SUPPORTS, isolation = READ_COMMITTED)
	public List<User> loadAllUsers() {
		return userDao.selectAll();
	}

	@Transactional(propagation = REQUIRES_NEW, isolation = SERIALIZABLE)
	public void saveUser(User user) {
		userDao.insert(user);
	}
}

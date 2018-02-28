package lab.dao;

import lab.model.User;

import java.util.List;
import java.util.Optional;


public interface UserDao {

    void insert(User user);

    /** @apiNote Attention! Very slow performance! */
    default Optional<User> select(int id) {
        return selectAll().stream()
                .filter(user -> user.getId() == id)
                .findAny();
    }

    List<User> selectAll();

}
